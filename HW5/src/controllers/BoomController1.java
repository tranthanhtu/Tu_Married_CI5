package controllers;

import models.Boom;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Dell latitude E6520 on 8/8/2016.
 */
public class BoomController1 extends SingleController implements Colliable{
    public static final int SPEED_BOOM = 2;

    protected int radius;
    public BoomController1(Boom gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
        this.gameVector.dy = SPEED_BOOM;
        this.radius = 200;
    }

    @Override
    public void run() {
        super.run();
        if(this.getGameObject().getY() > 800) {
            this.getGameObject().destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            this.getGameObject().destroy();
            EnemyControllerManager.instance.destroyForRadius(radius, this.getGameObject().getX(), this.gameObject.getY());
        }
    }
}

