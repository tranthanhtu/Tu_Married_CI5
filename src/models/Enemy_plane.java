package models;

/**
 * Created by Dell latitude E6520 on 7/28/2016.
 */
public class Enemy_plane {
    public int x;
    public int y;
    public int dx;
    public int dy;
    public Enemy_plane(){

    }


    public Enemy_plane(int x, int y){
        this.x = x;
        this.y = y;

    }
    public void moveTo(int x, int y){
        this.x += x;
        this.y += y;
    }
}
