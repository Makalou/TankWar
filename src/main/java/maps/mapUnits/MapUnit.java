package maps.mapUnits;

import java.awt.*;
import java.io.Serializable;

public abstract class MapUnit implements Serializable{

    public abstract void show(Graphics g);
    protected int x;
    protected int y;
    private static final long serialVersionUID=4720774397868974914L;
}
