package controllers.gamescenes;

import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Hau on 16/08/2016.
 */
public class OverGameScene implements GameScene,KeyListener {
    private Image background;
    private GameSceneListener gameSceneListener;

    public OverGameScene() {
        this.background = Utils.loadImage("resources/background_over1.png");
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;

    }

    @Override
    public void run() {

    }

    private static OverGameScene instance;
    public static OverGameScene getInstance() {
        if (instance == null) {
            instance = new OverGameScene();
        }
        return instance;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            while (GameSceneManager.getInstance().size() > 1) {
                GameSceneManager.getInstance().pop();
            }
            gameSceneListener.changeGameScene(GameSceneManager.getInstance().top());
        }
    }
}
