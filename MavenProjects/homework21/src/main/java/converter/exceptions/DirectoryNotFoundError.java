package converter.exceptions;

public class DirectoryNotFoundError extends RuntimeException {
    public DirectoryNotFoundError(String message) {
        super(message);
    }
}
