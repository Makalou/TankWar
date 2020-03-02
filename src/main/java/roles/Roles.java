package roles;

import java.util.LinkedList;
import java.util.Queue;

public final class Roles {

    public Roles(Hero hero,Enemy enemy){
        this.hero=hero;
        if(enemy!=null){
            enemys.add(enemy);
        }
    }
    //methods
    public Hero getHero() {
        return hero;
    }
    public Queue<Enemy> getEnemys() {
        return enemys;
    }
    private Hero hero;
    private volatile Queue<Enemy> enemys=new LinkedList<>();

}
