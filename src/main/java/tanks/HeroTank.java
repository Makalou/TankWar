package tanks;

import actions.FireTarget;
import roles.Actor;
import roles.Hero;
import utils.Direction;

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
}
