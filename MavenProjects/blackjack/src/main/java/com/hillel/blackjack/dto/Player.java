package com.hillel.blackjack.dto;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> hand = new ArrayList<>();

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}
