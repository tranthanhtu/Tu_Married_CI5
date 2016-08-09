package controllers;

import models.Boom;
import views.ImageDrawer;

import java.awt.*;
import java.util.Random;

/**
 * Created by Dell latitude E6520 on 8/9/2016.
 */
public class BoomControllerManager extends ControllerManager {
    public static final int TIME_CREATE_GIFT = 100;
    private int count;
    public BoomControllerManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        int enX;
        int enY = 0;
        if(count % TIME_CREATE_GIFT == 0 && count / TIME_CREATE_GIFT == 5 ) {
            count = 0;
            Random random = new Random();
            enX = random.nextInt(550);
            BoomController2 giftBoomController = new BoomController2(
                    new Boom(enX, enY),
                    new ImageDrawer("resources/boom1.png")
            );
            this.add(giftBoomController);
        } else if (count % TIME_CREATE_GIFT == 0){
            Random random = new Random();
            enX = random.nextInt(550);
            BoomController1 giftBoomController = new BoomController1(
                    new Boom(enX, enY),
                    new ImageDrawer("resources/boom2.png")
            );
            this.add(giftBoomController);
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    public static final BoomControllerManager instance = new BoomControllerManager();

}