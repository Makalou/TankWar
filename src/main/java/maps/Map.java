package maps;

import maps.mapUnits.MapUnit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Stack;

public class Map {
    public Map(String name){
        try (
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/mapinfo/"+name))) {
            mapUnits= (Stack<MapUnit>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapUnits.forEach(i-> System.out.println(i.getName()));
        mapUnits.forEach(i-> {
            try {
                i.setShell();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    private Stack<MapUnit> mapUnits;

    public Stack<MapUnit> getMapUnits() {
        return mapUnits;
    }
}
