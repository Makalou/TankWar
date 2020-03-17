package actions;

import roles.Enemy;

import java.util.Iterator;
import java.util.Optional;
import java.util.Queue;

public class EnemyAutoMove implements Runnable {
    public EnemyAutoMove(Queue<Enemy> enemys){
            this.enemys=Optional.of(enemys);
    }
    private Optional<Queue<Enemy>> enemys;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                Thread.sleep(50);
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
