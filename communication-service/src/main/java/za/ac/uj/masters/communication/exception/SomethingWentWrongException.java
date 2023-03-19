package za.ac.uj.masters.communication.exception;

public class SomethingWentWrongException extends RuntimeException {
    public SomethingWentWrongException(String message) {
        super(message);
    }
}
