package Physics;

import java.util.Arrays;

public interface Controllable extends Movable {
   void setV(int v);
   int getV();
   void setDirection(int direction);
}
