package moblima.Exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super("Email is invalid! Try again.");
    }

    public InvalidEmailException(String message) {
        super(message);
    }
}