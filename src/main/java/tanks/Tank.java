package tanks;

import components.physics.Movable;
import components.physics.Rigidbody;
import components.physics.collider.BoxCollider;
import components.physics.collider.Collider;
import components.physics.collider.ColliderHolder;
import components.weapons.Bullet;
import utils.Direction;
import utils.State;
import utils.Vector;
import utils.controller.Firable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class Tank extends Rigidbody implements Movable, Firable, ColliderHolder {

    //methods
    public int getX(){return xp;}
    public int getY(){return yp;}
    public Direction getDirection(){return direction;}
    public int getV(){return v;}
    public void setV(int v){this.v=v;}

    public State getState() {
        return state;
    }

    public final void show(Graphics g){
        int flag=0;
        flag=(flag+1)%2;
        if(v==0) flag=0;
        g.drawImage(img,xp-17,yp-17,xp+17,yp+17,
                direction.ordinal()*68 +flag*34,style*34,
                direction.ordinal()*68 +34*(flag+1),34*(style+1),null);
    }
    public void xMove(int v){
        xp+=v;
    }
    public void yMove(int v){ yp +=v; }
    public Bullet fire(int v){
        switch (direction){
            case UP:return new Bullet(this,xp,yp-25,new Vector(v,Direction.UP));
            case DOWN:return new Bullet(this,xp,yp+25,new Vector(v,Direction.DOWN));
            case LEFT:return new Bullet(this,xp-25,yp,new Vector(v,Direction.LEFT));
            case RIGHT:return new Bullet(this,xp+25,yp,new Vector(v,Direction.RIGHT));
        }
        return null;
    }
    public Collider getCollider(){
        return collider;
    }
    //constructor
    protected Tank(int x,int y,int s){
        xp=x;
        yp =y;
        style=s;
        direction = Direction.UP;
        v=0;
        try{
            img= ImageIO.read(new File("src/main/resources/robots_sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //attributes
    protected static Image img=null;
    protected final int style;
    protected Direction direction;
    protected State state;
    protected BoxCollider collider=new BoxCollider(this,34,34);
}
