package Tanks;

import java.util.Random;

public final class SpriteTank extends Tank {
    public SpriteTank(int x,int y,int s){
        super(x,y,s);
    }
    public void RandomMove(){
        switch (direction){
            case 0:yMove(-3);break;
            case 68:xMove(3);break;
            case 136:yMove(3);break;
            case 204:xMove(-3);break;
        }
        int isChange=random.nextInt(10);
        if(isChange==0){
           direction =random.nextInt(4)*68;
        }
    }

    private Random random=new Random();
}
