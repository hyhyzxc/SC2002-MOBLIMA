package moblima.Exceptions;

/**
 * Represents an InvalidEmailException. 
 * Concrete base class that extends Exception.
 * @author Darren Lee
 * @version 1.0
 * @since 2022-11-06
 */
public class InvalidEmailException extends Exception {
    /**
     * Creates a InvalidEmailException with a default error message.
     */
    public InvalidEmailException() {
        super("Email is invalid! Try again.");
    }
    /**
     * Creates a InvalidEmailException with a given error message.
     * @param message this InvalidEmailException's error messgae.
     */
    public InvalidEmailException(String message) {
        super(message);
    }
}