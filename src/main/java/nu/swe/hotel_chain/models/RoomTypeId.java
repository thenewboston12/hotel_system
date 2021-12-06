package nu.swe.hotel_chain.models;

import java.io.Serializable;

public class RoomTypeId implements Serializable {
    private String hotel_id;
    private String r_type;

    public RoomTypeId(){}

    public RoomTypeId(String hotel_id, String r_type) {
        this.hotel_id = hotel_id;
        this.r_type = r_type;
    }
}
