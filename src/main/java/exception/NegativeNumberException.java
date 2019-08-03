package exception;

public class NegativeNumberException extends Exception {

    private static final String message = "Negatives not allowed";

    public NegativeNumberException() {
        super(message);
    }
}
