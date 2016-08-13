package controllers.Enemy;

/**
 * Created by Hau on 13/08/2016.
 */
public class ZicZigFlyBehavior implements FlyBehavior {
    private int count;

    public ZicZigFlyBehavior() {
        this.count = 0;
    }

    @Override
    public void doFly(EnemyController enemyController) {
        count++;
        if (count == 1) {
            enemyController.getGameVector().dx = enemyController.SPEED;
        }
        if (enemyController.getGameObject().getX() >=600 || enemyController.getGameObject().getX() <= 0){
            enemyController.getGameVector().dx = -enemyController.getGameVector().dx;
        }
    }
}
