package maps;

import maps.mapUnits.MapUnit;
import maps.mapUnits.MapUnitFactory;
import maps.mapUnits.UnitPosition;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Stack;

public class Map {
    public Map(String name) {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/mapinfo/map"))) {
            positions = (Stack<UnitPosition>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show(Graphics g) throws IOException {
        for (UnitPosition position : positions) {
            MapUnit mapUnit= MapUnitFactory.getMapUnit(position.getWho());
                if (position.getWho().equals(mapUnit.getName())) {
                    mapUnit.show(g, mapUnit.getShell(), position);
                }
        }
    }
    private Stack<UnitPosition> positions = new Stack<>();

}
