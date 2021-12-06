package nu.swe.hotel_chain.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bills")
@IdClass(BillId.class)
public class Bill {
    @Id
    @Column(name = "guest_id")
    private int guest_id;

    @Id
    @Column(name = "res_id")
    private int res_id;

    @Id
    @Column(name = "hotel_id")
    private String hotel_id;

    @Column(name = "service_type")
    private String service_type;

    @Column(name = "total_price")
    private float total_price;

    @Column(name = "time")
    private Timestamp time;

    public Bill(){}

    public Bill(int guest_id, int res_id, String hotel_id, String service_type, float total_price, Timestamp time) {
        this.guest_id = guest_id;
        this.res_id = res_id;
        this.hotel_id = hotel_id;
        this.service_type = service_type;
        this.total_price = total_price;
        this.time = time;
    }

    public Bill(int res_id, String hotel_id, String service_type, int total_price, Timestamp time) {
        this.res_id = res_id;
        this.hotel_id = hotel_id;
        this.service_type = service_type;
        this.total_price = total_price;
        this.time = time;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "guest_id=" + guest_id +
                ", res_id=" + res_id +
                ", hotel_id='" + hotel_id + '\'' +
                ", service_type='" + service_type + '\'' +
                ", total_price=" + total_price +
                ", time=" + time +
                '}';
    }
}
