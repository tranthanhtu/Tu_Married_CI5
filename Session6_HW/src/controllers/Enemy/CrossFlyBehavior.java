package controllers.Enemy;

/**
 * Created by Hau on 13/08/2016.
 */
public class CrossFlyBehavior implements FlyBehavior {
    @Override
    public void doFly(EnemyController enemyController) {
        enemyController.getGameVector().dx = enemyController.SPEED;
    }
}
