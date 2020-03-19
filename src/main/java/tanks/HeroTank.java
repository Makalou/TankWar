package tanks;

import actions.FireTarget;
import components.physics.collider.Collider;
import components.physics.collider.ColliderHolder;
import components.weapons.Bullet;
import roles.Actor;
import roles.Hero;
import utils.Direction;
import utils.State;

@Actor
public final class HeroTank extends Tank implements Hero {

    private HeroTank(int x, int y, int s){
        super(x,y,s);
    }

    public final static HeroTank Instance=new HeroTank(400,300,0);

    @Override
    public void setDirection(Direction direction) {
        this.direction=direction;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void trigger(ColliderHolder other) {
        if(other instanceof Bullet||other instanceof SpriteTank){
            state= State.RUINED;
        }
    }

    @Override
    public void trigger(Collider other) {

    }
}
