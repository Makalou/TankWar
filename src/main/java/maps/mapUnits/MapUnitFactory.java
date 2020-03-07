package maps.mapUnits;

import java.util.HashMap;

public class MapUnitFactory {
    private static HashMap<String, MapUnit> mapUnitPool = new HashMap<>();

    public static MapUnit getMapUnit(String name, int x, int y) {
        switch (name) {
            case "grass":
             return new Grass(x,y);
            case "stone":
                return new Stone(x,y);
            case "water":
                return new Water(x,y);
        }
        return null;
    }
}
