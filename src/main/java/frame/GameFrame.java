package frame;

import actions.EnemyFire;
import animation.Draw;
import components.weapons.Bullet;
import org.omg.PortableServer.THREAD_POLICY_ID;
import utils.controller.Controller;
import maps.Map;
import roles.Roles;
import actions.EnemyAutoBirth;
import actions.EnemyAutoMove;
import utils.controller.Firable;
import utils.controller.FireController;

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
        setResizable(false);
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
        this.addKeyListener(Controller.getControllerTo(roles.getHero()));
        if(roles.getHero() instanceof Firable){
            FireController fireController=new FireController((Firable) roles.getHero());
            bullets=fireController.getBullets();
            this.addKeyListener(fireController);
        }
        if(enemyBirthFlag ==true){
            if(map.getHotPoints()==null){
                System.out.println("You haven't set hotpoints yet!");
                return;
            }
            Thread enemyBirth=new Thread(new EnemyAutoBirth(roles.getEnemys(),map.getHotPoints()),"enemyBirth");
            enemyBirth.setDaemon(true);
            enemyBirth.start();
        }
        if(enemyMoveFlag==true){
            Thread enemyMove=new Thread(new EnemyAutoMove(roles.getEnemys()),"enemyMove");
            enemyMove.setDaemon(true);
            enemyMove.start();
        }
        Thread enemyFire=new Thread(new EnemyFire(roles.getEnemys(),roles.getHero(),bullets),"EnemyFire");
        enemyFire.setDaemon(true);
        enemyFire.start();
        Thread draw=new Thread(new Draw(this));
        draw.setDaemon(true);
        draw.start();
    }
    public GameFrame setRoles(Roles roles){
        if (roles==null) return this;
        this.roles=roles;
        return this;
    }
    public GameFrame setMaps(Map map){
        this.map=map;
        return  this;
    }
    public GameFrame setEnemyAction(boolean enemybirth,boolean enemymove){
        if(roles.getEnemys()==null){
            System.out.println("You haven't set enemies yet!");
            return this;
        }
        this.enemyBirthFlag =enemybirth;
        this.enemyMoveFlag =enemymove;
        return this;
    }
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        gOffScreen = offScreenImage.getGraphics();
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
        if(bullets!=null){
            for(Bullet bullet:bullets){
                bullet.show(gOffScreen);
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

    private Roles roles;
    private Map map;
    private ArrayList<Bullet> bullets=new ArrayList<>();


    private boolean enemyBirthFlag =false;
    private boolean enemyMoveFlag =false;
    private final boolean singleplayer=true;
    private final boolean multiplayer=true;
}

