package com.hillel.blackjack.service;

import com.hillel.blackjack.exception.CardDeckEmptyException;
import com.hillel.blackjack.exception.CardDeckTotalException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckServiceTest {
    private CardDeckService cds;

    @BeforeEach
    void setUp() {
        cds = new CardDeckService();
    }

    @Test
    void createOneDeck() {
        cds.createDeck(1);
        assertEquals(52, cds.getTotalCardNumber());
    }

    @Test
    void createEightDeck() {
        cds.createDeck(8);
        assertEquals(8 * 52, cds.getTotalCardNumber());
    }


    @Test
    void createZeroDeckException() {
        CardDeckTotalException cardDeckTotalException = assertThrows(CardDeckTotalException.class, () -> cds.createDeck(0));
        assertEquals("Number of deck must be between 1 to 8", cardDeckTotalException.getMessage());
    }


    @Test
    void createNineDeckException() {
        CardDeckTotalException cardDeckTotalException = assertThrows(CardDeckTotalException.class, () -> cds.createDeck(9));
        assertEquals("Number of deck must be between 1 to 8", cardDeckTotalException.getMessage());
    }

    @Test
    void getCard() {
        cds.createDeck(1);
        assertEquals(52, cds.getTotalCardNumber());
        cds.getCard();
        assertEquals(51, cds.getTotalCardNumber());
    }

    @Test
    void getCardEmptyException() {
        CardDeckService cds = new CardDeckService();
        CardDeckEmptyException cardDeckEmptyException = assertThrows(CardDeckEmptyException.class,
                cds::getCard);
        assertEquals("No available card ....", cardDeckEmptyException.getMessage());
    }
}