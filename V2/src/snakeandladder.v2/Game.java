package snakeandladder.v2;

import java.util.*;

public class Game {

    Board board;
    Dice dice;
    Queue<Player> players;
    DifficultyStrategy difficulty;

    public Game(List<Player> playerList, DifficultyStrategy difficulty) {
        this.players = new LinkedList<>(playerList);
        this.difficulty = difficulty;
    }

    public void createGame() {

        board = new Board(100);
        dice = new Dice();

        BoardInitializer initializer = new BoardInitializer();
        initializer.initializeBoard(board, difficulty);
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