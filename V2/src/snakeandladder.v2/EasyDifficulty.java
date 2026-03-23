package snakeandladder.v2;

public class EasyDifficulty implements DifficultyStrategy {

    public int getSnakeCount() {
        return 4;
    }

    public int getLadderCount() {
        return 6;
    }
}