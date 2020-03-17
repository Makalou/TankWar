package utils.controller;
import components.physics.Movable;
import tanks.Tank;
import utils.Direction;

public interface Controllable extends Movable {
   void setV(int v);
   int getV();
   void setDirection(Direction direction);
   Direction getDirection();
}
