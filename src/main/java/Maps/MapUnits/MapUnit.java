package Maps.MapUnits;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class MapUnit {
    protected static Image img = null;

    public MapUnit() {
        try {
            img = ImageIO.read(new File("src/main/resources/robots_sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
