package components.physics.collider;

import java.awt.*;

/**
 * @author Makalou
 * @date 3/17/2020-4:19 PM
 */
public class BoxCollider extends Collider {
    public BoxCollider(ColliderHolder obj,int width,int height){
        this.colliderHolder =obj;
        this.width=width;
        this.height=height;
    }
    public BoxCollider(int x,int y,int width,int height){
        colliderHolder=null;
        xp=x;
        yp=y;
        this.width=width;
        this.height=height;
    }
    @Override
    public boolean isCollided(Collider other) {
        if(colliderHolder!=null) {
            xp = colliderHolder.getX() - width / 2;
            yp = colliderHolder.getY() - height / 2;
        }
        if(other instanceof BoxCollider){
            return this.getRec().intersects(((BoxCollider) other).getRec());
        }
        if(other instanceof CircleCollider){
            Rectangle rec=new Rectangle(other.getX()-((CircleCollider) other).getR(),other.getY()-((CircleCollider) other).getR(),
                    2*((CircleCollider) other).getR(),2*((CircleCollider) other).getR());
            return this.getRec().intersects(rec);
        }
        return false;
    }

    private int width;
    private int height;
    private Rectangle rec;

    public Rectangle getRec() {
        if(rec==null) {
            rec = new Rectangle(getX()-width/2, getY()-height/2, width, height);
            return rec;
        }
        rec.setLocation(getX()-width/2,getY()-height/2);
        return rec;
    }
}
