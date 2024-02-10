package com.kmb;

import java.util.Random;

public class Computer {
    private Random random;

    public Computer() {
        this.random = new Random();
    }

    public Move getMove() {
        int randomNumber = random.nextInt(3);
        return switch (randomNumber) {
            case 0 -> Move.ROCK;
            case 1 -> Move.PAPER;
            case 2 -> Move.SCISSORS;
            default -> throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
    }
}
