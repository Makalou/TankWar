package utils.controller;

import components.weapons.Bullet;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @author Makalou
 * @date 3/17/2020-10:05 PM
 */
public class FireController extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        if(lock==false&&e.getKeyCode()==KeyEvent.VK_J){
            bullets.add(fir.fire(10));
            lock=true;
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        lock=false;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public FireController(Firable fir){
        this.fir=fir;
    }
    Firable fir;
    private ArrayList<Bullet> bullets=new ArrayList<>();
    private boolean lock=false;
}
