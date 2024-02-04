package hw18.exceptions;

public class ProductCategoryNotFoundException extends RuntimeException {
    public ProductCategoryNotFoundException(String message) {
        super(message);
    }
}
