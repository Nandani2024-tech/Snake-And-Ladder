package snakeandladder.v1;

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

        // Adding jumps instead of snakes & ladders
        board.jumps.put(99, new Jump(99, 10)); // Snake
        board.jumps.put(70, new Jump(70, 20)); // Snake

        board.jumps.put(5, new Jump(5, 25));   // Ladder
        board.jumps.put(40, new Jump(40, 80)); // Ladder
    }

    public void startGame() {

        while (true) {

            Player currentPlayer = players.poll();

            int roll = dice.rollDice();
            System.out.println(currentPlayer.name + " rolled " + roll);

            int newPosition = currentPlayer.position + roll;

            newPosition = board.getNextPosition(newPosition);

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