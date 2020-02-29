package Threads.Enemy;

import Tanks.SpriteTank;

import java.util.Queue;

public class EnemyMove extends Thread {
    public EnemyMove(Queue<SpriteTank> enemys){
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
                for(SpriteTank enemy:enemys) {
                    enemy.RandomMove();
                }
            }
        });
    }
}
