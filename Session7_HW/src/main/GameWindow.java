package main;

import controllers.*;

import controllers.bombs.BombControllerManager;
import controllers.enemies.EnemyBulletControllerManager;
import controllers.enemies.EnemyControllerManager;
import controllers.gamescenes.*;
import models.GameSetting;
import utils.Utils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Stack;


/**
 * Created by qhuydtvt on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable, GameSceneListener {
    Image background;

    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;
    Thread thread;
    GameSetting gameSetting;
    GameScene currentGameScene;
    GameSceneManager gameSceneManager;

//    PlaneController planeController1;

    public GameWindow() {
        configUI();
        gameSceneManager = GameSceneManager.getInstance();
        changeGameScene(new MenuGameScene());


        this.addKeyListener(PlaneController.instance);

//        this.addMouseMotionListener(new MouseMotionListener() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                plane1.moveTo(e.getX() - plane2Width / 2,
//                        e.getY() - plane2Height / 2);
//
//            }
//
//        });

        this.bufferedImage = new BufferedImage(gameSetting.getScreenWidth(), gameSetting.getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
        this.bufferImageGraphic = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    private void configUI() {
        gameSetting = GameSetting.getInstance();
        this.setVisible(true);
        this.setSize(gameSetting.getScreenWidth(), gameSetting.getScreenHeight());
        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    @Override
    public void update(Graphics g) {
        this.currentGameScene.draw(bufferImageGraphic);
        g.drawImage(bufferedImage, 0, 0, null);

    }

    @Override
    public void run() {
        while (true) {
            try {
                this.currentGameScene.run();
                Thread.sleep(gameSetting.getThreadDelay());
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void changeGameScene(GameScene gameScene) {
        try{
            removeKeyListener(currentGameScene.getKeyListener());
        } catch (NullPointerException e) {

        }
        this.currentGameScene = gameScene;
        this.currentGameScene.setGameSceneListener(this);
        this.addKeyListener(gameScene.getKeyListener());
        gameSceneManager.push(currentGameScene);
    }
}
