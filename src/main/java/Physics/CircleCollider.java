package Physics;

public class CircleCollider extends Collider {
    @Override
    public boolean collided(int x,int y) {
        if(Math.pow((xp-x),2)+Math.pow((yp-y),2)<=r*r)
            return true;
        else return false;
    }
    public boolean collided(CircleCollider c){
        if(Math.pow((xp-c.xp),2)+Math.pow((yp-c.yp),2)<=r*r)
            return true;
        else return false;
    }

    protected double r;
}
