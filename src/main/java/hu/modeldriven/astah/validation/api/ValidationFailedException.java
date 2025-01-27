package hu.modeldriven.astah.validation.api;

public class ValidationFailedException extends Exception {

    public ValidationFailedException(String message) {
        super(message);
    }

    public ValidationFailedException(Exception e) {
        super(e);
    }

}
