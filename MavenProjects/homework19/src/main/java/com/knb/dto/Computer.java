package com.knb.dto;

import java.util.Random;

public class Computer {
    private Random random;

    public Computer() {
        this.random = new Random();
    }

    public Move getMove() {
        int randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case 0:
                return Move.ROCK;
            case 1:
                return Move.PAPER;
            case 2:
                return Move.SCISSORS;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
        }
    }
}
