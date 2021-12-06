package nu.swe.hotel_chain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, optional = false)
    @JoinColumns({
            @JoinColumn(name = "guest_id", referencedColumnName = "guest_id", insertable = false, updatable = false),
            @JoinColumn(name = "res_id", referencedColumnName = "res_id", insertable = false, updatable = false)
    })
    @JsonBackReference
    private Reservation reservation;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumns({
            @JoinColumn(name = "service_type", referencedColumnName = "service_type", insertable = false, updatable = false),
            @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id", insertable = false, updatable = false)
    })
    @JsonBackReference
    private Service service;


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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
                ", reservation=" + reservation +
                ", service=" + service +
                '}';
    }
}
