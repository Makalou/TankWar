package Tanks;

import Physics.Movable;
import Physics.Rigidbody;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class Tank extends Rigidbody implements Movable {

    public int getV(){return v;}
    public void setV(int v){this.v=v;}
    public void setDirection(int direction){this.direction = direction;}

    public final void show(Graphics g){
        int flag=0;
        flag=(flag+1)%2;
        if(v==0) flag=0;
        g.drawImage(img,xp,yp,xp+34,yp+34,
                direction +flag*34,style*34,
                direction +34*(flag+1),34*(style+1),null);
    }
    public void xMove(int v){
        xp+=v;
    }
    public void yMove(int v){
        yp +=v; }
    //constructor
    protected Tank(int x,int y,int s){
        xp=x;
        yp =y;
        style=s;
        direction =0;
        v=0;
        try{
            img= ImageIO.read(new File("src/main/resources/robots_sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static Image img=null;
    protected final int style;
    protected int direction;
}
