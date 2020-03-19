package components.physics.collider;

import java.awt.*;

public class CircleCollider extends Collider {
    public CircleCollider(ColliderHolder obj,int r){
        if(obj==null){
            return;
        }
        this.r=r;
        this.colliderHolder =obj;
    }
    public CircleCollider(int x,int y,int r){
        colliderHolder=null;
        xp=x;
        yp=y;
        this.r=r;
    }

    public boolean isCollided(Collider other) {
        if(colliderHolder!=null) {
            xp = colliderHolder.getX();
            yp = colliderHolder.getY();
        }
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

}
