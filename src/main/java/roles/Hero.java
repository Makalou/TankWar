package roles;

import components.physics.controller.Controllable;

import java.awt.*;

public interface Hero extends Controllable {
    void show(Graphics gOffScreen);
}
