package actions;

import roles.Enemy;
import tanks.SpriteTank;

import java.util.Queue;

public class EnemyMove extends Thread {
    public EnemyMove(Queue<Enemy> enemys){
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
