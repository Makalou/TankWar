package components.physics.collider;

import components.physics.Rigidbody;

public abstract class Collider extends Rigidbody {

    public abstract boolean isCollided(Collider other);
    public void trigger(Collider other){
        if(colliderHolder!=null) {
            if(other.getColliderHolder()!=null) {
                colliderHolder.trigger(other.getColliderHolder());
            }
            else {
                colliderHolder.trigger(other);
            }
        }
    }

    public ColliderHolder getColliderHolder() {
        return colliderHolder;
    }

    public int getX(){
        if(colliderHolder!=null) {
            xp = colliderHolder.getX();
        }
        return xp;
    }
    public int getY(){
        if(colliderHolder!=null) {
            yp = colliderHolder.getY();
        }
        return yp;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    protected ColliderHolder colliderHolder;
    protected State state=State.Registrable;
    public enum State{
        Registrable,
        Registered,
        Ruined
    }
}
