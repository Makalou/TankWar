package components.physics.collider;

import javax.swing.*;
import java.awt.*;

public class CircleCollider extends Collider {
    public CircleCollider(hasCollider obj,int r){
        if(obj==null){
            return;
        }
        this.r=r;
        this.obj=obj;
    }

    public boolean isCollided(Collider other) {
        xp=obj.getX();
        yp=obj.getY();
        if(other instanceof CircleCollider) {
            double d2=Math.pow((xp - other.getX()), 2) + Math.pow((yp - other.getY()), 2);
            return d2<=Math.pow((r+((CircleCollider) other).getR()),2);
        }
        if(other instanceof BoxCollider){
            Rectangle rec=new Rectangle(xp,yp,2*r,2*r);
            return rec.intersects(((BoxCollider) other).getRec());
        }
            return false;
    }
    private int r;

    public int getR() {
        return r;
    }

    private hasCollider obj;
}
