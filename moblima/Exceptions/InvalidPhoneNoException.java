package moblima.Exceptions;
/**
 * Represents an InvalidPhoneNoException. 
 * Concrete base class that extends Exception.
 * @author Darren Lee
 * @version 1.0
 * @since 2022-11-06
 */
public class InvalidPhoneNoException extends Exception {
    /**
     * Creates a InvalidPhoneNoException with a given error message.
     */
    public InvalidPhoneNoException() {
        super("Handphone Number is invalid. Please try again.");
    }
    /**
     * Creates a InvalidPhoneNoException with a given error message.
     * @param message this InvalidPhoneNoException's error messgae.
     */
    public InvalidPhoneNoException(String message) {
        super(message);
    }
}