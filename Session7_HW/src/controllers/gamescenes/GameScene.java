package controllers.gamescenes;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Hau on 16/08/2016.
 */
public interface GameScene extends Runnable{
    void draw(Graphics g);
    KeyListener getKeyListener();
    void setGameSceneListener(GameSceneListener gameSceneListener);
}
