import frame.GameFrame;
import maps.HotPoint;
import maps.Map;

import roles.Roles;
import tanks.HeroTank;
import tanks.SpriteTank;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        GameFrame frame = GameFrame.getInstance("Tank War",800,600);
        /////////////////////////////////////////////////////////////////////////////
        frame.setRoles(new Roles(HeroTank.Instance,new SpriteTank(100,100,1)));
        ArrayList<HotPoint> hotPoints=new ArrayList<>();
        hotPoints.add(new HotPoint(300,300));
        hotPoints.add(new HotPoint(400,400));
        frame.setMaps(hotPoints,new Map("map"));
        frame.setEnemyAction(true,true);
        frame.start();
    }

}




