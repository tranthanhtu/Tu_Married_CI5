package controllers;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class ControllerManager implements BaseController {

    private Vector<SingleController> singleControllerVector;

    public ControllerManager() {
        singleControllerVector = new Vector<SingleController>();
    }

    public void add(SingleController singleController) {
        this.singleControllerVector.add(singleController);
    }

    @Override
    public void draw(Graphics g) {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while(singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if(singleController.getGameObject().isAlive()) {
                    singleController.draw(g);
                }
            }
        }
    }

    @Override
    public void run() {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while(singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if(!singleController.getGameObject().isAlive()) {
                    singleControllerIterator.remove();
                } else {
                    singleController.run();
                }
            }
        }
    }

    public void destroyAll() {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while(singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                singleController.gameObject.destroy();
            }
        }
    }
    public void destroyForRadius(int radius, int x, int y) {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while (singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                double deltaX = singleController.getGameObject().getX() - x;
                double deltaY = singleController.getGameObject().getY() - y;
                double distance = Math.pow(deltaX, 2) + Math.pow(deltaY, 2);
                distance = Math.sqrt(distance);
                if(distance < radius) {
                    singleController.getGameObject().destroy();
                }
            }
        }
    }
}
