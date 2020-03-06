package frame;

import components.physics.controller.Controller;
import maps.HotPoint;
import maps.Map;
import maps.mapUnits.UnitPosition;
import roles.Roles;
import actions.EnemyAutoBirth;
import actions.EnemyAutoMove;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    //constructor
    protected GameFrame(String string, int width, int height) {
        super(string);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        /////////////////////////////////////////////////////////////////////////
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

    public void start(){
        if(enemybirth ==true){
            if(hotPoints==null){
                System.out.println("You haven't set hotpoints yet!");
                return;
            }
            enemyBirth=new EnemyAutoBirth(roles.getEnemys(),hotPoints);
            enemyBirth.start();
        }
        if(enemymove==true){
            enemyMove=new EnemyAutoMove(roles.getEnemys());
            enemyMove.start();
        }
        Draw.start();
    }
    public void setRoles(Roles roles){
        if (roles==null) return;
        this.roles=roles;
        this.addKeyListener(Controller.getControllerTo(roles.getHero()));
    }
    public void setMaps(ArrayList<HotPoint> hotPoints,Map map){
        this.map=map;
        this.hotPoints=hotPoints;
    }
    public void setEnemyAction(boolean enemybirth,boolean enemymove){
        if(roles.getEnemys()==null){
            System.out.println("You haven't set enemies yet!");
            return;
        }
        this.enemybirth =enemybirth;
        this.enemymove=enemymove;
    }

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
        if(map!=null){
            try {
                map.show(gOffScreen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        g.drawImage(offScreenImage,0,0,null);
    }
    //attributes
    private static String GAME_NAME;
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;

    private Image offScreenImage = null;
    private Graphics gOffScreen = null;
    private  Roles roles;
    private Map map;
    private ArrayList<HotPoint>hotPoints;

    private boolean enemybirth =false;
    private boolean enemymove=false;

    Thread Draw =new Thread(()->{
        while(true){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    });
    EnemyAutoBirth enemyBirth;
    EnemyAutoMove enemyMove;
}

