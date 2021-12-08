package nu.swe.hotel_chain.exceptions;

public class IllegalIdException extends RuntimeException {
    public IllegalIdException() {
    }

    public IllegalIdException(String message) {
        super(message);
    }
}
