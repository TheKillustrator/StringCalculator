package exception;

import java.util.List;

public class NegativeNumberException extends Exception {

    private static final String message = "Negatives not allowed: ";

    public NegativeNumberException(List<Integer> numbers) {
        super(message + numbers.toString());
    }
}
