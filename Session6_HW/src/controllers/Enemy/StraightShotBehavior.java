package controllers.Enemy;

import models.EnemyBullet;
import models.GameObject;
import views.ImageDrawer;

/**
 * Created by Hau on 13/08/2016.
 */
public class StraightShotBehavior implements ShotBehavior {
    private int count;

    @Override
    public void doShot(EnemyController enemyController) {
        count++;
        if (count >= SHOT_PERIOD) {
            count = 0;
            GameObject gameObject = enemyController.getGameObject();
            EnemyBulletController enemyBulletController = new EnemyBulletController(
                    new EnemyBullet(
                            gameObject.getMiddleX() - EnemyBullet.SIZE / 2,
                            gameObject.getBottom()),
                    new ImageDrawer("resources/enemy_bullet.png")
            );
            enemyBulletController.getGameVector().dy = BULLET_SPEED;
            EnemyBulletControllerManager.instance.add(enemyBulletController);
        }

    }
}
