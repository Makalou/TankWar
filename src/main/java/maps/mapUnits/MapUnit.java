package maps.mapUnits;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public abstract class MapUnit implements Serializable {

    public MapUnit(String name,int x,int y){
        try {
            this.shell = ImageIO.read(new File("src/main/resources/map_units/"+name+".png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        this.name =name;
        this.x=x;
        this.y=y;
    }

    public String getName() {
        return name;
    }

    public void show(Graphics g){
        g.drawImage(shell,x-17,y-17,
                x+17,y+17,0,0,34,34,null);
    }

    public Image getShell() {
        return shell;
    }

    public void setShell() throws IOException {
        this.shell = ImageIO.read(new File("src/main/resources/map_units/"+name+".png"));
    }

    protected int x;
    protected int y;
    protected transient Image shell;
    protected String name;
    private static final long serialVersionUID=4720774397868974914L;
}
