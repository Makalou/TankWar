package components.physics.collider;

public class CircleCollider extends Collider {
    public CircleCollider(hasCollider obj,double r){
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
            return  (Math.pow((xp - other.getX()), 2) + Math.pow((yp - other.getY()), 2) )<= r * r;
        }
            return false;
    }
    private double r;
    private hasCollider obj;
}
