package actions;

import roles.Enemy;

import java.util.Optional;
import java.util.Queue;

public class EnemyAutoMove implements Runnable {
    public EnemyAutoMove(Queue<Enemy> enemys){
            this.enemys=Optional.of(enemys);
    }
    private Optional<Queue<Enemy>> enemys;

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(Enemy enemy:enemys.get()) {
                enemy.randomMove();
            }
        }
    }
}
