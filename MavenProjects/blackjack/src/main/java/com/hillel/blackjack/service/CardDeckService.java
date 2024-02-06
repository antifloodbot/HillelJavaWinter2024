package com.hillel.blackjack.service;

import com.hillel.blackjack.dto.Card;
import com.hillel.blackjack.dto.Rank;
import com.hillel.blackjack.dto.Suit;
import com.hillel.blackjack.exception.CardDeckEmptyException;
import com.hillel.blackjack.exception.CardDeckTotalException;

import java.util.Collections;
import java.util.Stack;

public class CardDeckService {

    private Stack<Card> deck = new Stack<>();

    public void createDeck(int total) {
        if (total < 1 || total > 8) {
            throw new CardDeckTotalException("Number of deck must be between 1 to 8");
        }
        for (int i = 0; i < total; i++) {
            for (Suit s : Suit.values()) {
                for (Rank r : Rank.values()) {
                    deck.add(new Card(s, r));
                }
            }
        }
        Collections.shuffle(deck);
    }

    public Card getCard() {
        if (deck.isEmpty()) {
            throw new CardDeckEmptyException("No available card ....");
        }
        return deck.pop();
    }

    public int getTotalCardNumber() {
        return deck.size();
    }

    public Stack<Card> getDeck(){
        return deck;
    }
}
