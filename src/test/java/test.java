import com.sun.org.apache.xml.internal.security.keys.storage.implementations.CertsInFilesystemDirectoryResolver;

import javax.sound.midi.SoundbankResource;
import java.net.URL;
import java.util.*;

/**
 * @author Makalou
 * @date 3/17/2020-10:35 PM
 */
public class test {

    public static void main(String[] args) {
        ArrayList<A> as=new ArrayList<>();
        for(int i=0;i<10;i++){
            as.add(new A(i));
        }
        while(true) {
            for (Iterator<A> iterator = as.iterator(); iterator.hasNext(); ) {
                A a = iterator.next();
                if (a.x != 10) {
                    as.remove(iterator);
                    continue;
                }
                System.out.println(a.x);
            }
        }

    }
}
class A{
    int x;
    public A(int i)
    {
        x=i;
    }
}
