package utils.controller;

import components.weapons.Bullet;
import tanks.Tank;
import utils.Direction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
        con.setV(3);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
              con.setDirection(Direction.UP);
                con.yMove(-Math.abs(con.getV()));
                break;
            case KeyEvent.VK_S:
               con.setDirection(Direction.DOWN);
                con.yMove(Math.abs(con.getV()));
                break;
            case KeyEvent.VK_A:
               con.setDirection(Direction.LEFT);
                con.xMove(-Math.abs(con.getV()));
                break;
            case KeyEvent.VK_D:
               con.setDirection(Direction.RIGHT);
                con.xMove(Math.abs(con.getV()));
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        con.setV(0);
    }

    private Controller(Controllable c){
        con=c;
    }

    private static class ControllerInstance{
        private static final Controller Instance=new Controller(con);
    }
    public static Controller getControllerTo(Controllable c){
        con=c;
        return ControllerInstance.Instance;
    }

    private static Controllable con;
}
