package nu.swe.hotel_chain.models;

import java.io.Serializable;

public class RoomId implements Serializable {
    private int r_number;
    private String hotel_id;

    public RoomId(){}

    public RoomId(int r_number, String hotel_id) {
        this.r_number = r_number;
        this.hotel_id = hotel_id;
    }
}
