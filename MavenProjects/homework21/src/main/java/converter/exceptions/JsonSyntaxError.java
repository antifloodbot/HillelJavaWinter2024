package converter.exceptions;

public class JsonSyntaxError extends RuntimeException {
    public JsonSyntaxError(String message) {
        super(message);
    }
}
