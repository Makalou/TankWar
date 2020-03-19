package components.physics.collider;

import components.physics.Rigidbody;

public interface ColliderHolder {
    int getX();
    int getY();
    Collider getCollider();
    void trigger(ColliderHolder other);
    void trigger(Collider other);
}
