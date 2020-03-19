package main;

import frame.GameFrame;
import maps.HotSpot;
import maps.Map;

import roles.Roles;
import tanks.HeroTank;
import tanks.SpriteTank;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<HotSpot> hotSpots=new ArrayList<>();
        hotSpots.add(new HotSpot(300,300));
        hotSpots.add(new HotSpot(400,400));
        /////////////////////////////////////////////////////////////////////////////
        GameFrame frame = GameFrame.getInstance("Tank War",800,600)
                .setRoles(new Roles(HeroTank.Instance,new SpriteTank(300,300,1)))
                .setMaps(new Map("map",hotSpots))
                .setEnemyAction(false,true);
        frame.start();
    }
}




