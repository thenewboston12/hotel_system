package nu.swe.hotel_chain.exceptions;

public class NotAvailableRoomException extends RuntimeException {
    public NotAvailableRoomException() {
    }

    public NotAvailableRoomException(String message) {
        super(message);
    }
}
