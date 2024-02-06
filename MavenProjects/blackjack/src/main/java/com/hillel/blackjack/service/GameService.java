package com.hillel.blackjack.service;

import com.hillel.blackjack.dto.Card;
import com.hillel.blackjack.dto.GameResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class GameService {

    public Integer calculateComputerScores() {
        // from 17 to 25
        return new Random().nextInt(25 - 17) + 17;
    }

    // method return computer hand get random card from stack in range from 2 to 5
    public List<Card> computerHand(Stack<Card> cardDeck) {
        Integer numberOfCards = new Random().nextInt(4) + 2;
        List<Card> computerHand = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            computerHand.add(cardDeck.pop());
        }
        return computerHand;
    }

    public List<Card> computerHandAI(Stack<Card> cardDeck) {
        Integer result = 0;
        List<Card> computerHand = new ArrayList<>();
        computerHand.add(cardDeck.pop());
        do {
            computerHand.add(cardDeck.pop());
            result = calculateHandScores(computerHand);
            if (isBlackJack(computerHand)) {
                return computerHand;
            }
        } while (result < 17);

        return computerHand;
    }


    public void printHand(List<Card> hand) {
        hand.forEach((e -> System.out.print(e + " ")));
    }

    public Integer calculateHandScores(List<Card> hand) {
        int sum = hand.stream().mapToInt(Card::getCost).sum();
        if (isBlackJack(hand)) {
            return 21;
        }
        return sum;
    }

    private boolean isBlackJack(List<Card> hand) {
        return hand.stream().filter(card -> card.getCost() == 11).count() == 2;
    }

    public GameResult calculateGameResult(Integer computer, Integer player) {
        if (computer > 21 && player > 21) {
            return GameResult.LOSE;
        } else if (computer > 21) {
            return GameResult.PLAYER;
        } else if (player > 21) {
            return GameResult.COMPUTER;
        } else if (computer > player) {
            return GameResult.COMPUTER;
        } else if (player > computer) {
            return GameResult.PLAYER;
        } else {
            return GameResult.DRAW;
        }
    }
}
