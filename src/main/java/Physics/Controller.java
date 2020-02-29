package Physics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
        con.setV(5);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
              con.setDirection(0);
                con.yMove(-Math.abs(con.getV()));
                break;
            case KeyEvent.VK_S:
               con.setDirection(136);
                con.yMove(Math.abs(con.getV()));
                break;
            case KeyEvent.VK_A:
               con.setDirection(204);
                con.xMove(-Math.abs(con.getV()));
                break;
            case KeyEvent.VK_D:
               con.setDirection(68);
                con.xMove(Math.abs(con.getV()));
                break;
        }
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
