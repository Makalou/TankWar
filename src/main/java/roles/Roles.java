package roles;

import java.util.Queue;

public class Roles {

    public Roles(Hero hero,Queue<Enemy> enemys){
        this.hero=hero;
        this.enemys=enemys;
    }
    //methods
    public Hero getHero() {
        return hero;
    }

    public Queue<Enemy> getEnemys() {
        return enemys;
    }

    private Hero hero;
    private volatile Queue<Enemy> enemys;

}
