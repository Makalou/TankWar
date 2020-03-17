package roles;

import actions.FireTarget;
import utils.controller.Controllable;

import java.awt.*;

public interface Hero extends Controllable, FireTarget {
    void show(Graphics gOffScreen);
}
