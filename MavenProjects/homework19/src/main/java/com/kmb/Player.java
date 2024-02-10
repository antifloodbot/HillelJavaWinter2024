package com.kmb;

public class Player {
    private String name;
    private int wins;
    private int losses;
    private int draws;

    public Player(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void incrementWins() {
        wins++;
    }

    public int getLosses() {
        return losses;
    }

    public void incrementLosses() {
        losses++;
    }

    public int getDraws() {
        return draws;
    }

    public void incrementDraws() {
        draws++;
    }
}

