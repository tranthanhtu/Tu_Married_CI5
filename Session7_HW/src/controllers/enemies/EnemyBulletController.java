package controllers.enemies;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.SingleController;
import controllers.gamescenes.GameSceneListener;
import controllers.gamescenes.OverGameScene;
import controllers.gamescenes.PlayGameScene;
import models.EnemyBullet;
import views.GameDrawer;

/**
 * Created by qhuydtvt on 8/3/2016.
 */
class EnemyBulletController extends SingleController implements Colliable {
    private static final String TAG = EnemyBulletController.class.toString();
    GameSceneListener gameSceneListener;

    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    public EnemyBulletController(EnemyBullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    public GameSceneListener getGameSceneListener() {
        return gameSceneListener;
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            ((PlaneController)colliable).decreaseHP(1);
            gameObject.destroy();
        }
    }
}
