package tools;

import maps.mapUnits.MapUnit;
import maps.mapUnits.MapUnitFactory;

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
                mapUnits.push(MapUnitFactory.getMapUnit(mapUnitList[flag],e.getX(),e.getY()));
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
                        mapUnits.pop();
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
        if(mapUnits.size()==0) return;
        g.setColor(Color.BLACK);
        super.paint(g);
        System.out.println(mapUnits.size());
           mapUnits.forEach(i->i.show(g));
    }

    public void save() throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            mapUnits.forEach(System.out::println);
            output.writeObject(mapUnits);
        }
        try(FileOutputStream output=new FileOutputStream("src/main/resources/mapinfo/map")){
            output.write(buffer.toByteArray());
        }
        System.out.println("Successfully saved!");
    }

    private Stack<MapUnit> mapUnits =new Stack<>();
    private String[] mapUnitList =new String[]{"grass","stone","water"};
    private int flag=0;
}
