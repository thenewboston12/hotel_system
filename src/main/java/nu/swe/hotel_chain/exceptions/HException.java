package nu.swe.hotel_chain.exceptions;

public class HException extends RuntimeException{
    // custom exception
    public HException(String message) {
        super(message);
    }
}
