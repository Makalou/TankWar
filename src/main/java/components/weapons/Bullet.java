package components.weapons;
import components.physics.Movable;
import components.physics.Rigidbody;
import components.physics.collider.CircleCollider;
import components.physics.collider.Collider;
import components.physics.collider.ColliderHolder;
import utils.State;
import utils.Vector;
import utils.controller.Firable;

import java.awt.*;

public class Bullet extends Rigidbody implements Movable, ColliderHolder {
    public Bullet(Firable firer,int x,int y,Vector v){
        this.firer=firer;
        xp=x;
        yp=y;
        this.v=v;
        drag=0.001;
    }
    public void show(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(xp-4,yp-4,8,8);
       move();
    }

    public Firable getFirer() {
        return firer;
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
        if(i++>15){
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
    private Firable firer;
    private Collider collider=new CircleCollider(this,4);

    public int getX() {
        return xp;
    }

    @Override
    public int getY() {
        return yp;
    }

    @Override
    public Collider getCollider() {
        return collider;
    }

    @Override
    public void trigger(ColliderHolder other) {
        System.out.println("Hit"+other.toString());
        collider.setState(Collider.State.Ruined);
        state=State.RUINED;
    }

    @Override
    public void trigger(Collider other) {
        collider.setState(Collider.State.Ruined);
        state=State.RUINED;
    }
    public State state=State.HEALTHY;
}
