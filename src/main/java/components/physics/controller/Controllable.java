package components.physics.controller;
import components.physics.Movable;
import tanks.Tank;

public interface Controllable extends Movable {
   void setV(int v);
   int getV();
   void setDirection(Tank.Direction direction);
   Tank.Direction getDirection();
}
