package snakeandladder.v2;

import java.util.*;

public class Board {

    int size;
    Map<Integer, Jump> jumps;

    public Board(int size) {
        this.size = size;
        this.jumps = new HashMap<>();
    }

    public int getNextPosition(int position) {

        if (jumps.containsKey(position)) {
            Jump jump = jumps.get(position);

            if (jump.start > jump.end) {
                System.out.println("Bitten by snake!");
            } else {
                System.out.println("Climbed ladder!");
            }

            return jump.end;
        }

        return position;
    }
}