package maps.mapUnits;

public class MapUnitFactory {
    public static MapUnit creatMapUnit(String name,int x,int y) {
        switch (name){
            case "bricks":return new Bricks(name,x,y);
            case "grass":return new Grass(name,x,y);
            case "stone":return new Stone(name,x,y);
            case "water":return new Water(name,x,y);
        }
        return null;
    }
}
