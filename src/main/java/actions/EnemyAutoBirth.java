package actions;

import maps.HotPoint;
import roles.Enemy;
import tanks.SpriteTank;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class EnemyAutoBirth implements Runnable {
    public EnemyAutoBirth(Queue<Enemy> enemies, ArrayList<HotPoint> hotPoints) {
        this.enemies= Optional.of(enemies);
        this.hotPoints =Optional.of(hotPoints);
    }

    private Optional<Queue<Enemy>> enemies;
    private Optional<ArrayList<HotPoint>> hotPoints;

    @Override
    public void run() {
        while (true) {
            for (HotPoint hotPoint : hotPoints.get()) {
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
