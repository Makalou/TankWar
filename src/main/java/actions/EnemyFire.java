package actions;

import components.weapons.Bullet;
import roles.Enemy;
import tanks.Tank;
import utils.Direction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

/**
 * @author Makalou
 * @date 3/17/2020-11:09 PM
 */
public class EnemyFire implements Runnable {
    public EnemyFire(Queue<Enemy> enemys, FireTarget target, ArrayList<Bullet> bullets){
        this.enemys=enemys;
        this.target=target;
        this.bullets=bullets;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){
            for(Iterator<Enemy> it=enemys.iterator(); it.hasNext();){
                Enemy enemy=it.next();
                if((Math.abs(enemy.getY()-target.getY())<=34&&
                        ((enemy.getX()<target.getX()&&enemy.getDirection()== Direction.RIGHT)||
                                (enemy.getX()>target.getX()&&enemy.getDirection()== Direction.LEFT)))||
                        (Math.abs(enemy.getX()-target.getX())<=34&&
                                ((enemy.getY()<target.getY()&&enemy.getDirection()== Direction.DOWN)||
                                        (enemy.getY()>target.getY()&&enemy.getDirection()== Direction.UP)))) {
                 {
                     bullets.add(enemy.fire(6));
                }
                }
                }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }
    private Queue<Enemy> enemys;
    private FireTarget target;
    ArrayList<Bullet> bullets;
}
