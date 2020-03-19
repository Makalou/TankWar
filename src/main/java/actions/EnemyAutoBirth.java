package actions;

import maps.HotSpot;
import roles.Enemy;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class EnemyAutoBirth implements Runnable {
    public EnemyAutoBirth(ArrayList<Enemy> enemies, ArrayList<HotSpot> hotPoints) {
        this.enemies= Optional.of(enemies);
        this.hotPoints =Optional.of(hotPoints);
    }

    private Optional<ArrayList<Enemy>> enemies;
    private Optional<ArrayList<HotSpot>> hotPoints;

    @Override
    public void run() {
        while (true) {
            for (HotSpot hotPoint : hotPoints.get()) {
                synchronized (enemies) {
                    if (enemies.get().size() < 10) {
                        enemies.get().add(enemies.get().get(0).getInstance(hotPoint, 1));
                    }
                }
            }
            System.out.println("enemys number:" + enemies.get().size());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
