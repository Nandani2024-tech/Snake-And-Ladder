package snakeandladder.v0;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();
        players.add(new Player("P1"));
        players.add(new Player("P2"));

        Game game = new Game(players);
        game.createGame();
        game.startGame();
    }
}