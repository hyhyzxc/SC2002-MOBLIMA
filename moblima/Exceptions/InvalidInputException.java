package moblima.Exceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        super("Input is invalid! Try again.");
    }

    public InvalidInputException(String message) {
        super(message);
    }
}