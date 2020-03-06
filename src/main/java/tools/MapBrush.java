package tools;

import maps.mapUnits.MapUnit;
import maps.mapUnits.MapUnitFactory;
import maps.mapUnits.UnitPosition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MapBrush extends JFrame {

    protected MapBrush(String string, int width, int height) {
        super(string);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(mapUnitList[flag]);
                try {
                    mapUnitInstances.add(MapUnitFactory.getMapUnit(mapUnitList[flag]));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                positions.push(new UnitPosition(e.getX(),e.getY(),mapUnitList[flag]));
                repaint();
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        flag=(flag+mapUnitList.length-1)%mapUnitList.length;break;
                    case KeyEvent.VK_DOWN:
                        flag=(flag+1)%mapUnitList.length;break;
                    case KeyEvent.VK_C:
                        positions.pop();
                        repaint();
                        break;
                    case KeyEvent.VK_ENTER:
                        try {
                            save();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        break;
                }
            }
        });
    }

    public void paint(Graphics g){
        if(positions.size()==0) return;
        if(mapUnitInstances.size()==0) return;
        g.setColor(Color.BLACK);
        super.paint(g);
        System.out.println(positions.size());
        System.out.println(mapUnitInstances.size());
           for(UnitPosition position:positions) {
               for(MapUnit mapUnit:mapUnitInstances){
                   if(position.getWho().equals(mapUnit.getName())) {
                       mapUnit.show(g,mapUnit.getShell(),position);
                   }
               }
           }
           }

    public void save() throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            positions.forEach(System.out::println);
            output.writeObject(positions);
        }
        try(FileOutputStream output=new FileOutputStream("src/main/resources/mapinfo/map")){
            output.write(buffer.toByteArray());
        }
        System.out.println("Successfully saved!");
    }

    private Stack<UnitPosition>positions=new Stack<>();
    private ArrayList<MapUnit>mapUnitInstances=new ArrayList<>();
    private String[] mapUnitList =new String[]{"grass","stone","water"};
    private int flag=0;
}
