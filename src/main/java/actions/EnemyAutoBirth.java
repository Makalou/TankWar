package actions;

import maps.HotSpot;
import roles.Enemy;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Queue;

public class EnemyAutoBirth implements Runnable {
    public EnemyAutoBirth(Queue<Enemy> enemies, ArrayList<HotSpot> hotPoints) {
        this.enemies= Optional.of(enemies);
        this.hotPoints =Optional.of(hotPoints);
    }

    private Optional<Queue<Enemy>> enemies;
    private Optional<ArrayList<HotSpot>> hotPoints;

    @Override
    public void run() {
        while (true) {
            for (HotSpot hotPoint : hotPoints.get()) {
                if (enemies.get().size() < 10) {
                    enemies.get().add(enemies.get().peek().getInstance(hotPoint, 1));
                } else {
                    enemies.get().poll();
                }
            }
            System.out.println("enemys number:" + enemies.get().size());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
