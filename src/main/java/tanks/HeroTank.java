package tanks;

import components.physics.controller.Controllable;
import roles.Hero;

public final class HeroTank extends Tank implements Controllable , Hero {

    private HeroTank(int x, int y, int s){
        super(x,y,s);
    }

    public final static HeroTank Instance=new HeroTank(400,300,0);
}
