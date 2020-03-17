package components.weapons;
import components.physics.Movable;
import components.physics.Rigidbody;
import utils.Vector;

import java.awt.*;

public class Bullet extends Rigidbody implements Movable {
    public Bullet(int x,int y,Vector v){
        xp=x;
        yp=y;
        this.v=v;
        drag=0.001;
    }
    public void show(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(xp,yp,8,8);
       move();
    }

    @Override
    public void xMove(int v) {
        xp+=v;
    }

    @Override
    public void yMove(int v) {
        yp+=v;
    }
    public void move(){
        if(i++>40){
            v.magnitude-=drag;
            i=0;
        }
        switch (v.direction){
            case UP:yMove(-v.magnitude);break;
            case DOWN:yMove(v.magnitude);break;
            case LEFT:xMove(-v.magnitude);break;
            case RIGHT:xMove(v.magnitude);break;
        }
    }

    private Vector v;
    private int i=0;
}
