package utils;

import java.lang.reflect.InvocationTargetException;

public class Use {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // MapBrush mapBrush=new MapBrush("test",800,600);
        ClassScanner classScanner=new ClassScanner();
        classScanner.load();
    }

}
