package controllers.gamescenes;

import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.bombs.BombControllerManager;
import controllers.enemies.EnemyBulletControllerManager;
import controllers.enemies.EnemyControllerManager;
import models.GameObjectWithHP;
import models.Plane;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Hau on 16/08/2016.
 */
public class PlayGameScene implements GameScene {
    private Image background;
    private GameSceneListener gameSceneListener;

    public PlayGameScene() {
        this.background = Utils.loadImage("resources/background.png");

    }

    private void reset() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);

        PlaneController.instance.draw(g);
        EnemyControllerManager.instance.draw(g);
        EnemyBulletControllerManager.instance.draw(g);
        BombControllerManager.instance.draw(g);
    }

    @Override
    public KeyListener getKeyListener() {
        return null;
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        PlaneController.instance.setGameSceneListener(gameSceneListener);
    }

    @Override
    public void run() {
        PlaneController.instance.run();
        EnemyBulletControllerManager.instance.run();
        EnemyControllerManager.instance.run();
        BombControllerManager.instance.run();
        CollsionPool.instance.run();

        System.out.println(((GameObjectWithHP)PlaneController.instance.getGameObject()).getHp());

    }
}
