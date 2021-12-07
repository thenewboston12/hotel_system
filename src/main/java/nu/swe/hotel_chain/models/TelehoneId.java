package nu.swe.hotel_chain.models;

import java.io.Serializable;

public class TelehoneId implements Serializable {
    private String hotel_id;
    private String h_phone;

    public TelehoneId(){}

    public TelehoneId(String hotel_id, String h_phone) {
        this.hotel_id = hotel_id;
        this.h_phone = h_phone;
    }
}
