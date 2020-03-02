package actions;

import maps.HotPoint;
import roles.Enemy;
import tanks.SpriteTank;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class EnemyAutoBirth extends Thread {
    public EnemyAutoBirth(Queue<Enemy> enemies,ArrayList<HotPoint> hotPoints) {
        super(() -> {
            while (true) {
                for (HotPoint hotPoint : hotPoints) {
                        if (enemies.size() < 10) {
                            enemies.add(enemies.peek().getInstance(hotPoint, 1));
                        } else {
                            enemies.poll();
                        }
                }
                System.out.println("enemys number:" + enemies.size());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
