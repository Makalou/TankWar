package Tanks;

import Maps.HotPoint;
import Roles.Enemy;
import java.security.SecureRandom;


public final class SpriteTank extends Tank implements Enemy {
    public SpriteTank(int x,int y,int s){
        super(x,y,s);
        v=3;
    }
    public SpriteTank(HotPoint hotPoint,int s){
        super(hotPoint.getX(),hotPoint.getY(),s);
        v=3;
    }
    public void RandomMove(){
        switch (direction){
            case UP:yMove(-v);break;
            case RIGHT:xMove(v);break;
            case DOWN:yMove(v);break;
            case LEFT:xMove(-v);break;
        }
        if(random.nextInt(20)==0){
            direction=Direction.values()[random.nextInt(4)];
        }
    }

    private SecureRandom random=new SecureRandom();
}
