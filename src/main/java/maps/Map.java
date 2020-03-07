package maps;

import maps.mapUnits.MapUnit;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Stack;

public class Map {
    public Map(String name) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/mapinfo/map"))) {
            mapUnits = (Stack<MapUnit>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show(Graphics g) throws IOException {
       mapUnits.forEach(i->i.show(g));
    }
    private Stack<MapUnit> mapUnits = new Stack<>();

}
