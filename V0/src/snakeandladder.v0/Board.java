package snakeandladder.v0;

import java.util.*;

public class Board {

    int size;
    List<Snake> snakes;
    List<Ladder> ladders;

    public Board(int size) {
        this.size = size;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
    }

    public int checkJump(int position) {

        for (Snake snake : snakes) {
            if (snake.head == position) {
                System.out.println("Bitten by snake!");
                return snake.tail;
            }
        }

        for (Ladder ladder : ladders) {
            if (ladder.start == position) {
                System.out.println("Climbed ladder!");
                return ladder.end;
            }
        }

        return position;
    }
}