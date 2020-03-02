import actions.EnemyBirth;
import actions.EnemyMove;
import frame.GameFrame;
import maps.HotPoint;
import roles.Enemy;
import roles.Roles;
import tanks.HeroTank;
import tanks.SpriteTank;
import tanks.Tank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        GameFrame frame = GameFrame.getInstance("Tank War",800,600);
        Queue<Enemy> enemies= new LinkedList<>();
        Roles roles=new Roles(HeroTank.Instance,enemies);
        frame.setRoles(roles);
        ArrayList<HotPoint> hotPoints=new ArrayList<>();
        hotPoints.add(new HotPoint(300,300));
        EnemyBirth enemyBirth=new EnemyBirth(enemies,hotPoints);
        EnemyMove enemyMove=new EnemyMove(enemies);
        enemyBirth.start();
        enemyMove.start();
    }

}




