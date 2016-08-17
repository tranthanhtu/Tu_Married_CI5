package controllers.enemies;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public interface ShotBehavior {
    int BULLET_SPEED = 7;
    int SHOT_PERIOD = 20;

    void doShot(EnemyController enemyController);
}
