package nu.swe.hotel_chain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_id")
    private int bill_id;

    @Column(name = "res_id")
    private int res_id;

    @Column(name = "hotel_id")
    private String hotel_id;

    @Column(name = "service_type")
    private String service_type;

    @Column(name = "total_price")
    private float total_price;

    @Column(name = "time")
    private Timestamp time;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "res_id", referencedColumnName = "res_id", insertable = false, updatable = false)
    @JsonBackReference
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "service_type", referencedColumnName = "service_type", insertable = false, updatable = false),
            @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id", insertable = false, updatable = false)
    })
    @JsonBackReference
    private Service service;


    public Bill(){}

    public Bill(int bill_id, int res_id, String hotel_id, String service_type, float total_price, Timestamp time) {
        this.bill_id = bill_id;
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

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
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
                "bill_id=" + bill_id +
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
