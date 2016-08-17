package controllers.gamescenes;

import java.util.Stack;

/**
 * Created by Hau on 17/08/2016.
 */
public class GameSceneManager {
    Stack<GameScene> gameSceneStack;

    public GameSceneManager() {
        this.gameSceneStack = new Stack<GameScene>();
    }

    public int size() {
        return gameSceneStack.size();
    }

    public void pop() {
        this.gameSceneStack.pop();
    }

    public void push(GameScene gameScene) {
        this.gameSceneStack.push(gameScene);
    }

    public GameScene top() {
        return gameSceneStack.firstElement();
    }

    private static GameSceneManager instance;

    public static GameSceneManager getInstance() {
        if (instance == null) {
            instance = new GameSceneManager();
        }
        return instance;
    }
}
