package com.hillel.blackjack.dto;

public enum Rank {

    Two("2", 2, 2),
    Three("3", 3, 3),
    Four("4", 4, 4),
    Five("5", 5, 5),
    Six("6", 6,6),
    Seven("7", 7, 7),
    Eight("8", 8, 8),
    Nine("9", 9, 9),
    Ten("10", 10, 10),
    Jack("J", 11, 10),
    Queen("Q", 12, 10),
    King("K", 13, 10),
    Ace("A", 14, 11);

    private final String name;
    private final  int values;
    private final int cost;

    public String getName() {
        return name;
    }

    public int getValues() {
        return values;
    }

    public int getCost() {
        return cost;
    }

    Rank(String name, int values, int cost) {
        this.name = name;
        this.values = values;
        this.cost = cost;
    }
}
