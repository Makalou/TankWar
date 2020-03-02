package components.physics.collider;

import components.physics.Rigidbody;

public abstract class Collider extends Rigidbody {

    public abstract boolean isCollided(Collider other);

    public int getX(){
        return xp;
    }
    public int getY(){
        return yp;
    }
}
