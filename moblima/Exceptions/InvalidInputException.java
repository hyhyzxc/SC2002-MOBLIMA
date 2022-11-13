package moblima.Exceptions;
/**
 * Represents an InvalidInputException. 
 * Concrete base class that extends Exception.
 * @author Goh Hong Yi
 * @version 1.0
 * @since 2022-11-13
 */
public class InvalidInputException extends Exception {
    /**
     * Creates a InvalidInputException with a given error message.
     */
    public InvalidInputException() {
        super("Input is invalid! Try again.");
    }
    /**
     * Creates a InvalidInputException with a given error message.
     * @param message this InvalidEmailException's error messgae.
     */
    public InvalidInputException(String message) {
        super(message);
    }
}