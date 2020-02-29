package Tanks;

import Physics.Controllable;

public final class HeroTank extends Tank implements Controllable {

    private HeroTank(int x, int y, int s){
        super(x,y,s);
    }

    public final static HeroTank Instance=new HeroTank(400,300,0);
}
