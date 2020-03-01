package Components.Physics;

import Tanks.Tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
        con.setV(5);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
              con.setDirection(Tank.Direction.UP);
                con.yMove(-Math.abs(con.getV()));
                break;
            case KeyEvent.VK_S:
               con.setDirection(Tank.Direction.DOWN);
                con.yMove(Math.abs(con.getV()));
                break;
            case KeyEvent.VK_A:
               con.setDirection(Tank.Direction.LEFT);
                con.xMove(-Math.abs(con.getV()));
                break;
            case KeyEvent.VK_D:
               con.setDirection(Tank.Direction.RIGHT);
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
