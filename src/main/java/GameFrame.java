
import Physics.Controller;
import Tanks.HeroTank;
import Tanks.SpriteTank;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class GameFrame extends JFrame {
    //constructor
    private GameFrame(String string, int width, int height) {
        super(string);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.addKeyListener(Controller.getControllerTo(hero));
        }
    private static class MyFrameInstance{
        private static final GameFrame Instance=new GameFrame(FrameName,GAME_WIDTH,GAME_HEIGHT);
    }
    public static GameFrame getInstance(String str, int width, int height){
        FrameName=str;
        GAME_WIDTH=width;
        GAME_HEIGHT=height;
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
        hero.show(gOffScreen);
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
    private HeroTank hero=HeroTank.Instance;
    public Queue<SpriteTank> enemys=new LinkedList<SpriteTank>();

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
    Thread EnemyMoves =new Thread(()->{
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(SpriteTank enemy:enemys) {
                enemy.RandomMove();
            }
        }
    });
    Thread EnemyBirth=new Thread(()->{
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(enemys.size()<5)
            enemys.add(new SpriteTank(200,200,1));
    });

}

