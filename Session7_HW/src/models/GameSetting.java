package models;

/**
 * Created by Hau on 16/08/2016.
 */
public class GameSetting {
    private static final int WIDTH_DELAUT = 600;
    private static final int HEIGHT_DEFAULT = 800;
    private static final int THREAD_DELAY = 17;
    private static GameSetting instance;
    private int screenWidth;
    private int screenHeight;
    private int threadDelay;

    private GameSetting(int screenWidth, int screenHeight, int threadDelay) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.threadDelay = threadDelay;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getThreadDelay() {
        return threadDelay;
    }

    public void setThreadDelay(int threadDelay) {
        this.threadDelay = threadDelay;
    }


    public static GameSetting getInstance() {
        if (instance == null) {
            instance = new GameSetting(WIDTH_DELAUT, HEIGHT_DEFAULT, THREAD_DELAY);
        }
        return instance;
    }
}
