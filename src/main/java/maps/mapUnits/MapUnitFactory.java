package maps.mapUnits;

import java.io.IOException;
import java.util.HashMap;

public class MapUnitFactory {
    private static HashMap<String,MapUnit> mapUnitPool=new HashMap<>();
    public static MapUnit getMapUnit(String name) throws IOException {
        if(!mapUnitPool.containsKey(name)){
            switch (name) {
                case "grass":
                    mapUnitPool.put(name,new Grass(name));
                    break;
                case "stone":
                    mapUnitPool.put(name,new Stone(name));
                    break;
                case "water":
                    mapUnitPool.put(name,new Water(name));
                    break;
            }
        }
        return (MapUnit)mapUnitPool.get(name);
    }
}
