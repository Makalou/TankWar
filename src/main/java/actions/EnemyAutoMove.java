package actions;

import roles.Enemy;

import java.util.Queue;

public class EnemyAutoMove extends Thread {
    public EnemyAutoMove(Queue<Enemy> enemys){
        super(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(true){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(Enemy enemy:enemys) {
                    enemy.RandomMove();
                }
            }
        });
    }
}
