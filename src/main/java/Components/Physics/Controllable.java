package Components.Physics;
import Tanks.Tank;

public interface Controllable extends Movable {
   void setV(int v);
   int getV();
   void setDirection(Tank.Direction direction);
   Tank.Direction getDirection();
}
