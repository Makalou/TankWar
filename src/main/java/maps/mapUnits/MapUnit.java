package maps.mapUnits;

import java.awt.*;
import java.io.Serializable;

public abstract class MapUnit{

    public void show(Graphics g,Image shell,UnitPosition position){
        g.drawImage(shell,position.getX()-17,position.getY()-17,
                position.getX()+17,position.getY()+17,0,0,34,34,null);
    }
    public abstract Image getShell();
    public abstract String getName();
    private static final long serialVersionUID=4720774397868974914L;
}
