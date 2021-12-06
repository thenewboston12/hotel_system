package nu.swe.hotel_chain.models;

import java.io.Serializable;

public class ReservationId implements Serializable {
    private int res_id;
    private int guest_id;

    public ReservationId(){}

    public ReservationId(int res_id, int guest_id) {
        this.res_id = res_id;
        this.guest_id = guest_id;
    }
}
