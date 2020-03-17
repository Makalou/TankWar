package roles;

import components.weapons.Bullet;
import maps.HotSpot;
import utils.Direction;

import java.awt.*;

public interface Enemy {
    void show(Graphics gOffScreen);
    void randomMove();
    Enemy getInstance(HotSpot hotPoint, int s);
    int getX();
    int getY();
    Direction getDirection();
    Bullet fire(int v);
}
