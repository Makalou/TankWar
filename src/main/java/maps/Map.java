package maps;

import maps.mapUnits.MapUnit;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Stack;

public class Map {
    public Map(String name,ArrayList<HotSpot> hotPoints) {
        this.hotPoints=hotPoints;
        if (name != null) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/mapinfo/map"))) {
                mapUnits = (Stack<MapUnit>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<HotSpot> getHotPoints(){
        return hotPoints;
    }

    public void show(Graphics g) throws IOException {
        if(mapUnits==null){
            System.out.println("MapUnits not found!");
            return;
        }
       mapUnits.forEach(i->i.show(g));
    }
    private Stack<MapUnit> mapUnits = new Stack<>();
    private ArrayList<HotSpot> hotPoints;
}
