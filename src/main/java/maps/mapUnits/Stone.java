package maps.mapUnits;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public final class Stone extends MapUnit{
    public Stone(int x,int y) {
        this.x=x;
        this.y=y;
    }
    private static String name="stone";
    private transient static Image shell;

    static {
        try {
            shell = ImageIO.read(new File("src/main/resources/map_units/"+name+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show(Graphics g){
        g.drawImage(shell,x-17,y-17,
                x+17,y+17,0,0,34,34,null);
    }
}
