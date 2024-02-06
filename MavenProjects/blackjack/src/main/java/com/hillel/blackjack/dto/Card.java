package com.hillel.blackjack.dto;

public class Card {

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getCost() {
        return rank.getCost();
    }

    @Override
    public String toString() {
        return String.format("%s%s", rank.getName(), suit.getSymbol());
    }
}
