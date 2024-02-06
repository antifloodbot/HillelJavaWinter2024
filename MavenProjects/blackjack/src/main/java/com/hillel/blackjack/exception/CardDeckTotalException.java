package com.hillel.blackjack.exception;

public class CardDeckTotalException extends RuntimeException {
    public CardDeckTotalException(String message) {
        super(message);
    }
}
