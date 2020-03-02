package actions;

import maps.HotPoint;
import roles.Enemy;
import tanks.SpriteTank;

import java.util.ArrayList;
import java.util.Queue;

public class EnemyBirth extends Thread {
    public EnemyBirth(Queue<Enemy> enemys, ArrayList<HotPoint> hotPoints) {
        super(() -> {
            while (true) {
                for (HotPoint hotPoint : hotPoints) {
                    //synchronized () {
                        if (enemys.size() < 10) {
                            enemys.add(new SpriteTank(hotPoint, 1));
                        } else {
                            enemys.poll();
                        }
                   // }
                }
                System.out.println("enemys number:" + enemys.size());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
