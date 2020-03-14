package roles;

import maps.HotSpot;

import java.awt.*;

public interface Enemy {
    void show(Graphics gOffScreen);
    void randomMove();
    Enemy getInstance(HotSpot hotPoint, int s);
}
