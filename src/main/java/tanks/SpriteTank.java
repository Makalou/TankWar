package tanks;

import components.physics.collider.Collider;
import components.physics.collider.ColliderHolder;
import components.weapons.Bullet;
import maps.HotSpot;
import roles.Actor;
import roles.Enemy;
import utils.Direction;
import utils.State;

import java.security.SecureRandom;

@Actor
public final class SpriteTank extends Tank implements Enemy {
    public SpriteTank(int x,int y,int s){
        super(x,y,s);
        v=3;
    }
    public SpriteTank(HotSpot hotPoint, int s){
        super(hotPoint.getX(),hotPoint.getY(),s);
        v=3;
    }

    public void randomMove(){
        switch (direction){
            case UP:yMove(-v);break;
            case RIGHT:xMove(v);break;
            case DOWN:yMove(v);break;
            case LEFT:xMove(-v);break;
        }
        if(random.nextInt(20)==0){
            direction= Direction.values()[random.nextInt(4)];
        }
    }
    private void turnback(){
        switch (direction){
            case UP:direction=Direction.DOWN;break;
            case DOWN:direction=Direction.UP;break;
            case LEFT:direction=Direction.RIGHT;break;
            case RIGHT:direction=Direction.LEFT;break;
        }
    }
    @Override
    public Enemy getInstance(HotSpot hotPoint, int s) {
        return new SpriteTank(hotPoint,s);
    }
    private SecureRandom random=new SecureRandom();

    @Override
    public void trigger(ColliderHolder other) {
        if(other instanceof Bullet){
            if(((Bullet) other).getFirer() instanceof HeroTank){
                state= State.RUINED;
                collider.setState(Collider.State.Ruined);
                System.out.println("hit by hero!");
            }
            if(((Bullet) other).getFirer() instanceof SpriteTank){
                System.out.println("hit by friend!");
            }
        }
    }

    @Override
    public void trigger(Collider other) {
        turnback();
    }
}
