import Components.Physics.Controller;
import Maps.HotPoint;
import Tanks.HeroTank;
import Tanks.SpriteTank;
import Actions.EnemyBirth;
import Actions.EnemyMove;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GameFrame extends JFrame {
    //constructor
    private GameFrame(String string, int width, int height, HeroTank hero) {
        super(string);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.addKeyListener(Controller.getControllerTo(hero));
        hotPoints.add(new HotPoint(300,300));
        hotPoints.add(new HotPoint(200,200));
        /////////////////////////////////////////////////////////////////////////
        Draw.start();
        EnemyBirth.start();
        EnemyMoves.start();
    }
    private static class MyFrameInstance{
        private static final GameFrame Instance=new GameFrame(FrameName,GAME_WIDTH,GAME_HEIGHT,Hero);
    }
    public static GameFrame getInstance(String str, int width, int height,HeroTank hero){
        FrameName=str;
        GAME_WIDTH=width;
        GAME_HEIGHT=height;
        Hero=hero;
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
        Hero.show(gOffScreen);
        for(SpriteTank enemy:enemys) {
            enemy.show(gOffScreen);
        }
        g.drawImage(offScreenImage, 0, 0, null);
    }

    //attributes
    private static String FrameName;
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    private Image offScreenImage = null;
    private Graphics gOffScreen = null;
    private static HeroTank Hero;
    private volatile Queue<SpriteTank> enemys=new LinkedList<SpriteTank>();
    private ArrayList<HotPoint> hotPoints=new ArrayList<HotPoint>();

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
    Thread EnemyMoves =new EnemyMove(enemys);
    Thread EnemyBirth=new EnemyBirth(enemys,hotPoints);
}

