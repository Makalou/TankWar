package animation;

import java.awt.*;
import java.util.Optional;

/**
 * @author Makalou
 * @date 3/13/2020-9:42 AM
 */
public class Draw implements Runnable {
    Optional<Component> component;
    public Draw(Component component){
        this.component=Optional.of(component);
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            component.get().repaint();
        }
    }
}
