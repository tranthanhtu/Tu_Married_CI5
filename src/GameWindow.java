import models.Bullet;
import models.Enemy_plane;
import models.Plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Dell latitude E6520 on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    Image planeImage;
    Image plane2Image;
    Image plane3Image;
    Image bulletImage;
    Image enemyPlaneImage;
//    int planeX = 350;
//    int planeY = 600;
//    int planeX2 = 300;
//    int planeY2 = 600;

    Plane plane1;
    Plane plane2;
    Plane plane3;

//    Enemy_plane enemy_plane1;
//    Enemy_plane enemy_plane2;
    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;

    long timeCreateEnemyPlane = 0;
    int enemyPlaneImageWidth;
    int enemyPlaneImageHeight;



    Thread thread;
    Vector<Bullet> bulletVector;
    Vector<Enemy_plane> enemyPlaneVector;

    public GameWindow() {
        System.out.println("Game window contructor");
        this.setVisible(true);
        this.setSize(800,600);
        this.setLocation(0,0);
        plane1 = new Plane(300,600);
        plane2 = new Plane(250,600);
        plane3 = new Plane(10,20);




        bulletVector = new Vector<>();
        enemyPlaneVector = new Vector<>();
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
        try {
            bulletImage = ImageIO.read(new File("resources/bullet.png"));
            background = ImageIO.read(new File("resources/background.png"));
            planeImage = ImageIO.read(new File("resources/plane4.png"));
            plane2Image = ImageIO.read(new File("resources/plane3.png"));
            plane3Image = ImageIO.read(new File("resources/plane1.png"));
            enemyPlaneImage = ImageIO.read(new File("resources/enemy_plane_white_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.repaint();
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("mouseDragged");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                plane2.moveTo(e.getX() - 35 ,e.getY() - 25);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_SPACE:
                        Bullet bullet = new Bullet();
                        bullet.moveTo(plane2.x, plane2.y);
                        bulletVector.add(bullet);
                        break;
                    case KeyEvent.VK_LEFT:
                        plane1.x -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.x += 10;
                        break;
                    case KeyEvent.VK_UP:
                        plane1.y -=10;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.y += 10;
                        break;

                    case KeyEvent.VK_D:
                        plane3.x += 10;
                        break;
                    case KeyEvent.VK_A:
                        plane3.x -= 10;
                        break;
                    case KeyEvent.VK_S:
                        plane3.y +=10;
                        break;
                    case KeyEvent.VK_W:
                        plane3.y -= 10;
                        break;

                }
//                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        this.bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        this.bufferImageGraphic = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(Graphics g) {
        bufferImageGraphic.drawImage(background, 0, 0, null);
        bufferImageGraphic.drawImage(planeImage, plane1.x, plane1.y, null);
        bufferImageGraphic.drawImage(plane2Image, plane2.x, plane2.y,null);
        bufferImageGraphic.drawImage(plane3Image, plane3.x, plane3.y,null);

        for(Bullet bullet : bulletVector) {
            bufferImageGraphic.drawImage(bulletImage, bullet.x, bullet.y, null);
        }
        for (Enemy_plane enemyPlane : enemyPlaneVector) {
            bufferImageGraphic.drawImage(enemyPlaneImage, enemyPlane.x, enemyPlane.y, null);
        }
        g.drawImage(bufferedImage,0,0,null);
        System.out.println("Paint");
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(27);
//                for (Bullet bullet : bulletVector){
//                    bullet.y -= 10;
//                }
                if (System.currentTimeMillis() - timeCreateEnemyPlane >= 500 && enemyPlaneVector.size() < 10) {
                    timeCreateEnemyPlane = System.currentTimeMillis();

                    Random random = new Random();
                    Enemy_plane enemyPlane = new Enemy_plane(random.nextInt(550), 100);
                    enemyPlaneVector.add(enemyPlane);
                }
                Iterator<Enemy_plane> enemyPlaneIterator = enemyPlaneVector.iterator();
                while (enemyPlaneIterator.hasNext()) {
                    Enemy_plane plane = enemyPlaneIterator.next();
                    plane.y += 5;
                    if (plane.y >= 600) {
                        enemyPlaneIterator.remove();
                    }
                }

                Iterator<Bullet> bulletIterator = bulletVector.iterator();
                Iterator<Enemy_plane> enemyPlaneIterator1 = enemyPlaneVector.iterator();
                while (bulletIterator.hasNext()) {
                    Bullet bullet = bulletIterator.next();
                    bullet.y -= 10;
                    while (enemyPlaneIterator1.hasNext()) {
                        Enemy_plane enemyPlane = enemyPlaneIterator1.next();
                        Rectangle rectangleBullet = new Rectangle(bullet.x, bullet.y, bulletImage.getWidth(null), bulletImage.getHeight(null));
                        Rectangle rectangleEnemyPlane = new Rectangle(enemyPlane.x, enemyPlane.y, enemyPlaneImage.getWidth(null), enemyPlaneImage.getHeight(null));
                        if(rectangleBullet.intersects(rectangleEnemyPlane)) {
                            bulletIterator.remove();
                            enemyPlaneIterator1.remove();
                        }
//                        if (bullet.y <= enemyPlane.y
//                                && bullet.y >= enemyPlane.y
//                                && bullet.x >= enemyPlane.x
//                                && bullet.x <= enemyPlane.x ) {
//                            bulletIterator.remove();
//                            enemyPlaneIterator1.remove();
//                        }
                    }
                    if (bullet.y <= 100) {
                        bulletIterator.remove();
                    }
                }
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
