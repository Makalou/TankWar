package Components.Physics;

public interface Controllable extends Movable {
   void setV(int v);
   int getV();
   void setDirection(int direction);
   int getDirection();
}
