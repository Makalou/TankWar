package components.physics.collider;

import java.awt.*;

/**
 * @author Makalou
 * @date 3/17/2020-4:19 PM
 */
public class BoxCollider extends Collider {
    @Override
    public boolean isCollided(Collider other) {
        if(other instanceof BoxCollider){
            return this.getRec().intersects(((BoxCollider) other).getRec());
        }
        if(other instanceof CircleCollider){
            Rectangle rec=new Rectangle(other.getX(),other.getY(),
                    2*((CircleCollider) other).getR(),2*((CircleCollider) other).getR());
            return this.getRec().intersects(rec);
        }
        return false;
    }
    private int width;
    private int height;
    private Rectangle rec;

    public Rectangle getRec() {
        rec=new Rectangle(xp,yp,width,height);
        return rec;
    }
}
