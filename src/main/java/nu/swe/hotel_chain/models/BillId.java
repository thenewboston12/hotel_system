package nu.swe.hotel_chain.models;

import java.io.Serializable;

public class BillId implements Serializable {
    private int guest_id;
    private int res_id;
    private String hotel_id;

    public BillId(){}

    public BillId(int guest_id, int res_id, String hotel_id) {
        this.guest_id = guest_id;
        this.res_id = res_id;
        this.hotel_id = hotel_id;
    }
}
