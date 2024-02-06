package com.hillel.blackjack.service;

import com.hillel.blackjack.dto.Card;

import java.util.List;
import java.util.Random;

public class GameService {

    public Integer calculateComputerScores() {
        // from 17 to 25
        return new Random().nextInt(25 - 17) + 17;
    }

    public Integer calculateHandScores(List<Card> hand) {
        return hand.stream().mapToInt(Card::getCost).sum();
    }
}
