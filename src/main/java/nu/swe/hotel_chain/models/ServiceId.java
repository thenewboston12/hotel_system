package nu.swe.hotel_chain.models;

import java.io.Serializable;

public class ServiceId implements Serializable {
    private String service_type;
    private String hotel_id;

    public ServiceId(){}

    public ServiceId(String service_type, String hotel_id) {
        this.service_type = service_type;
        this.hotel_id = hotel_id;
    }
}
