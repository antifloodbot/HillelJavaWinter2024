package hw18.exceptions;

public class NotValidDiscountException extends RuntimeException {
    public NotValidDiscountException(String message) {
        super(message);
    }
}
