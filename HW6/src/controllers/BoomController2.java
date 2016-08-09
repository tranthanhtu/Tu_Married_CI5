package controllers;

import models.Boom;
import views.GameDrawer;

/**
 * Created by Dell latitude E6520 on 8/9/2016.
 */
public class BoomController2 extends BoomController1 implements Colliable  {

    public BoomController2(Boom gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.radius = 800;
    }

}