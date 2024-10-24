public class IllegalTypeOfCandyException extends IllegalArgumentException {
    public IllegalTypeOfCandyException(String message) {
        super(message);
    }

    public IllegalTypeOfCandyException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalTypeOfCandyException(Throwable cause) {
        super(cause);
    }

    public IllegalTypeOfCandyException() {
    }
}
