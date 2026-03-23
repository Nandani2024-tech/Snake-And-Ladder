package snakeandladder.v0;

import java.util.*;

public class Game {

    Board board;
    Dice dice;
    Queue<Player> players;

    public Game(List<Player> playerList) {
        this.players = new LinkedList<>(playerList);
    }

    public void createGame() {

        board = new Board(100);
        dice = new Dice();

        // Adding snakes
        board.snakes.add(new Snake(99, 10));
        board.snakes.add(new Snake(70, 20));

        // Adding ladders
        board.ladders.add(new Ladder(5, 25));
        board.ladders.add(new Ladder(40, 80));
    }

    public void startGame() {

        while (true) {

            Player currentPlayer = players.poll();

            int roll = dice.rollDice();
            System.out.println(currentPlayer.name + " rolled " + roll);

            int newPosition = currentPlayer.position + roll;

            newPosition = board.checkJump(newPosition);

            currentPlayer.position = newPosition;

            System.out.println(currentPlayer.name + " moved to " + newPosition);

            if (checkWinner(currentPlayer)) {
                System.out.println(currentPlayer.name + " wins!");
                break;
            }

            players.add(currentPlayer);
        }
    }

    public boolean checkWinner(Player player) {
        return player.position >= board.size;
    }
}