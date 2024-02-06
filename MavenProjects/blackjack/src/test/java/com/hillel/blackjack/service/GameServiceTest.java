package com.hillel.blackjack.service;

import com.hillel.blackjack.dto.Card;
import com.hillel.blackjack.dto.Rank;
import com.hillel.blackjack.dto.Suit;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    @RepeatedTest(20)
    void calculateComputerScores() {
        GameService gs = new GameService();
        int result = gs.calculateComputerScores();
        assertTrue(result > 16);
        assertTrue(result < 26);
    }

    @Test
    void calculateHandScores() {
        Card card1 = new Card(Suit.Diamonds, Rank.Three);
        Card card2 = new Card(Suit.Clubs, Rank.Seven);
        Card card3 = new Card(Suit.Hearts, Rank.Ace);
        List<Card> hand = List.of(card1, card2, card3);
        GameService gs = new GameService();
        assertEquals(21, gs.calculateHandScores(hand));

    }
}