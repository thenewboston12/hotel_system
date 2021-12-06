package nu.swe.hotel_chain.models;

import java.io.Serializable;

public class RoomPriceId implements Serializable {
    private String r_type;
    private String hotel_id;

    public RoomPriceId(){}

    public RoomPriceId(String r_type, String hotel_id) {
        this.r_type = r_type;
        this.hotel_id = hotel_id;
    }
}
