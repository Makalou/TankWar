package components.physics.collider;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;


/**
 * @author Makalou
 * @date 3/19/2020-3:42 PM
 */
public class ColliderHandler implements Runnable {
    private ArrayList<Collider> nonSelfs = new ArrayList<>();
    private ArrayList<Collider> onlySelf = new ArrayList<>();
    private ArrayList<Collider> common = new ArrayList<>();

    public void register(Collider collider,Catalog catalog){
        if(collider.getState()== Collider.State.Registered) return;
        switch (catalog) {
            case NonSelf:
                nonSelfs.add(collider);
                break;
            case OnlySelf:
                onlySelf.add(collider);
                break;
            case COMMON:
                common.add(collider);
                break;
        }
        collider.setState(Collider.State.Registered);
    }
    public void register(ColliderHolder colliderHolder, Catalog catalog) {
        register(colliderHolder.getCollider(),catalog);
    }

    public enum Catalog {
        NonSelf,
        COMMON,
        OnlySelf
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            synchronized (nonSelfs) {
                for (int i = 0; i < onlySelf.size(); i++) {
                    if (onlySelf.get(i).getState() == Collider.State.Ruined) {
                        onlySelf.remove(i);
                        continue;
                    }
                    for (int j = i + 1; j < onlySelf.size(); j++) {
                        if (onlySelf.get(j).getState() == Collider.State.Ruined) {
                            onlySelf.remove(j);
                            continue;
                        }
                        if (onlySelf.get(i).isCollided(onlySelf.get(j))) {
                            onlySelf.get(i).trigger(onlySelf.get(j));
                            onlySelf.get(i).trigger(onlySelf.get(i));
                        }
                    }
                }
            }
            //common
            synchronized (common){
            for (int i = 0; i < common.size(); i++) {
                if (common.get(i).getState() == Collider.State.Ruined) {
                    common.remove(i);
                    continue;
                }
                synchronized (nonSelfs) {
                    for (int k=0; k<nonSelfs.size();k++ ) {
                        if (nonSelfs.get(k).getState() == Collider.State.Ruined) {
                            nonSelfs.remove(nonSelfs.get(k));
                            continue;
                        }
                        if (nonSelfs.get(k).isCollided(common.get(i))) {
                            nonSelfs.get(k).trigger(common.get(i));
                            common.get(i).trigger(nonSelfs.get(k));
                        }
                    }
                }
                for (int j = i + 1; j < common.size(); j++) {
                    if (common.get(j).getState() == Collider.State.Ruined) {
                        common.remove(j);
                        continue;
                    }
                    if (common.get(i).isCollided(common.get(j))) {
                        common.get(i).trigger(common.get(j));
                        common.get(j).trigger(common.get(i));
                    }
                }
            }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
