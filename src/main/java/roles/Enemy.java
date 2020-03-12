package roles;

import maps.HotPoint;

import java.awt.*;

public interface Enemy {
    void show(Graphics gOffScreen);
    void randomMove();
    Enemy getInstance(HotPoint hotPoint,int s);
}
