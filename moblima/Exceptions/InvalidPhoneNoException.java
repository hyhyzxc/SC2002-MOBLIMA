package moblima.Exceptions;

public class InvalidPhoneNoException extends Exception {
    public InvalidPhoneNoException() {
        super("Handphone Number is invalid. Please try again.");
    }

    public InvalidPhoneNoException(String message) {
        super(message);
    }
}