package snakeandladder.v2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();
        players.add(new Player("P1"));
        players.add(new Player("P2"));

        DifficultyStrategy difficulty = new EasyDifficulty();

        Game game = new Game(players, difficulty);
        game.createGame();
        game.startGame();
    }
}