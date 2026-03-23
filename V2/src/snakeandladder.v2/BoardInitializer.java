package snakeandladder.v2;

import java.util.*;

public class BoardInitializer {

    public void initializeBoard(Board board, DifficultyStrategy difficulty) {

        int snakes = difficulty.getSnakeCount();
        int ladders = difficulty.getLadderCount();

        generateSnakes(board, snakes);
        generateLadders(board, ladders);
    }

    private void generateSnakes(Board board, int count) {

        Random rand = new Random();

        while (count > 0) {
            int head = rand.nextInt(board.size - 1) + 1;
            int tail = rand.nextInt(head);

            if (head > tail) {
                board.jumps.put(head, new Jump(head, tail));
                count--;
            }
        }
    }

    private void generateLadders(Board board, int count) {

        Random rand = new Random();

        while (count > 0) {
            int start = rand.nextInt(board.size - 1) + 1;
            int end = rand.nextInt(board.size - start) + start;

            if (end > start) {
                board.jumps.put(start, new Jump(start, end));
                count--;
            }
        }
    }
}