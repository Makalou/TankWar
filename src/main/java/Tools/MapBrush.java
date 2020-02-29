package Tools;

import javax.swing.*;
import java.util.Stack;

public class MapBrush extends JFrame {
    private MapBrush() {
    }
    private static volatile MapBrush instance;

    public static MapBrush getInstance() {
        if(instance==null){
            synchronized (MapBrush.class){
                if(instance==null)
                    instance=new MapBrush();
            }
        }
            return instance;
    }
}
