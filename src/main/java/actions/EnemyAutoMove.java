package actions;

import roles.Enemy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class EnemyAutoMove implements Runnable {
    public EnemyAutoMove(ArrayList<Enemy> enemys){
            this.enemys=Optional.of(enemys);
    }
    private Optional<ArrayList<Enemy>> enemys;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(Iterator<Enemy> it=enemys.get().iterator();it.hasNext();) {
                Enemy enemy=it.next();
                enemy.randomMove();
            }
        }
    }
}
