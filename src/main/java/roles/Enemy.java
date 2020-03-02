package roles;

import maps.HotPoint;

import java.awt.*;

public interface Enemy {
    void show(Graphics gOffScreen);
    void RandomMove();
    Enemy getInstance(HotPoint hotPoint,int s);
}
