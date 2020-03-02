package frame;

import components.physics.controller.Controller;
import maps.HotPoint;
import maps.Map;
import maps.mapUnits.MapUnits;
import roles.Roles;
import actions.EnemyBirth;
import actions.EnemyMove;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    //constructor
    private GameFrame(String string, int width, int height) {
        super(string);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        /////////////////////////////////////////////////////////////////////////
        Draw.start();
    }

    private static class MyFrameInstance {
        private static final GameFrame Instance = new GameFrame(GAME_NAME, GAME_WIDTH, GAME_HEIGHT);
    }
    public static GameFrame getInstance(String str, int width, int height) {
        GAME_NAME = str;
        GAME_WIDTH = width;
        GAME_HEIGHT = height;
        return MyFrameInstance.Instance;
    }

    //methods
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
            gOffScreen = offScreenImage.getGraphics();
        }
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        super.paint(gOffScreen);
        if (roles != null) {
            if (roles.getHero() != null) {
                roles.getHero().show(gOffScreen);
            }
            if (roles.getEnemys() != null) {
                roles.getEnemys().forEach(i -> i.show(gOffScreen));
            }
        }
        g.drawImage(offScreenImage,0,0,null);
    }

    public void setRoles(Roles roles){
        if (roles==null) return;
        this.roles=roles;
        this.addKeyListener(Controller.getControllerTo(roles.getHero()));
    }
    public void setMaps(ArrayList<Map> maps){
        if(maps==null ) return;
        this.maps=maps;
    }

    //attributes
    private static String GAME_NAME;
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    private Image offScreenImage = null;
    private Graphics gOffScreen = null;
    private  Roles roles;
    private ArrayList<Map> maps;

    Thread Draw=new Thread(()->{
        while(true){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    });
}

