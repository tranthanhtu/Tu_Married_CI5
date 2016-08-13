package controllers.Enemy;

import controllers.Colliable;
import controllers.PlaneController;
import controllers.SingleController;
import models.EnemyBullet;
import models.GameObject;
import views.GameDrawer;

/**
 * Created by qhuydtvt on 8/3/2016.
 */
class EnemyBulletController extends SingleController implements Colliable {

    public EnemyBulletController(EnemyBullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            colliable.getGameObject().destroy();
        }
    }
}
