package tools;

import roles.Actor;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;

/**
 * @author Makalou
 * @date 3/10/2020-6:10 PM
 */
public class ClassScanner {

    public void load() throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Optional<URL> url=Optional.of(classLoader.getResource(""));
           getAllClassesName(url.get().getPath());
           scanNeed(classFullNames);
         //  classFullNames.forEach(System.out::println);
    }

    public void getAllClassesName(String filePath){
        File file = new File(filePath);
        File[] files = file.listFiles();
        for(File ChildFile:files){
            if(ChildFile.isDirectory()){
                getAllClassesName(ChildFile.getPath());
            }
            if(ChildFile.getName().endsWith(".class")&&
                    !ChildFile.getName().contains("$")){
                String path=ChildFile.getPath();
                int index=path.indexOf("\\classes\\");
                path=path.substring(index+9).split("\\.")[0].replace("\\",".");
               classFullNames.add(path);
            }
        }
    }

    public void scanNeed(Set<String> classFullNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        for(String className: classFullNames){
            Optional<Class>cls=Optional.of(Class.forName(className));
            if(cls.get().getAnnotation(Actor.class)!=null){
                classes.add(cls.get());
                System.out.println("Actor: "+cls);
            }
        }
    }

    public Set<Class> getClasses(){
        return classes;
    }

    private Set<Class> classes=new HashSet<>();
    private Set<String> classFullNames =new HashSet<>();
    private ClassLoader classLoader= ClassScanner.class.getClassLoader();
}
