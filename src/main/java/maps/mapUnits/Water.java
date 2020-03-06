package maps.mapUnits;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public final class Water extends MapUnit {
    public Water(String name) throws IOException {
        this.name=name;
        this.shell = ImageIO.read(new File("src/main/resources/map_units/"+name+".png"));
    }
    private String name;
    private transient Image shell;
    public Image getShell() {
        return shell;
    }

    public String getName(){return name;}
}
