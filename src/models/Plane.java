package models;

/**
 * Created by Dell latitude E6520 on 7/27/2016.
 */
public class Plane {
    public int x;
    public int y;
    public int dx;
    public int dy;
    public void moveTo(){
        x += dx;
        y += dy;
    }
    public Plane(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }

}
