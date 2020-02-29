package Tanks;

import Maps.HotPoint;

import java.security.SecureRandom;
import java.util.Random;

public final class SpriteTank extends Tank implements Cloneable{
    public SpriteTank(int x,int y,int s){
        super(x,y,s);
    }
    public SpriteTank(HotPoint hotPoint,int s){
        super(hotPoint.getX(),hotPoint.getY(),s);
    }
    public void RandomMove(){
        switch (direction){
            case UP:yMove(-3);break;
            case RIGHT:xMove(3);break;
            case DOWN:yMove(3);break;
            case LEFT:xMove(-3);break;
        }
        if(random.nextInt(20)==0){
            direction=Direction.values()[random.nextInt(4)];
        }
    }

    private SecureRandom random=new SecureRandom();
}
