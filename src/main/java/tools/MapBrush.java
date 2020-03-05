package tools;

import maps.mapUnits.MapUnit;
import maps.mapUnits.MapUnitFactory;
import org.w3c.dom.ls.LSOutput;

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
                System.out.println(mapInfo.size());
                System.out.println(mapUnitList[flag]);
                mapInfo.push(MapUnitFactory.creatMapUnit(mapUnitList[flag],
                        e.getX(), e.getY()));
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
                        mapInfo.pop();
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
        g.setColor(Color.BLACK);
        if(mapInfo.size()==0) return;
        super.paint(g);
       mapInfo.forEach(i->i.show(g));
    }

    public void save() throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            mapInfo.forEach(System.out::println);
            output.writeObject(mapInfo);
        }
        try(FileOutputStream output=new FileOutputStream("src/main/resources/mapinfo/map")){
            output.write(buffer.toByteArray());
        }
        System.out.println("Successfully saved!");
    }

    private Stack<MapUnit>mapInfo=new Stack<>();
    private String[] mapUnitList =new String[]{"grass","stone","water"};
    private int flag=0;
}
