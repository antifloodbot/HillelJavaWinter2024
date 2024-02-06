package com.hillel.blackjack.exception;

public class NotEnoughtMoneyException extends RuntimeException {
    public NotEnoughtMoneyException(String message) {
        super(message);
    }
}
