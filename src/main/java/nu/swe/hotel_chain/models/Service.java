package nu.swe.hotel_chain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "services")
public class Service implements Serializable {
    @Id
    @Column(name = "service_type")
    private String service_type;

    @Id
    @Column(name = "hotel_id")
    private String hotel_id;

    @Column(name = "s_price")
    private double s_price;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "hotel_id", unique = true, nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    private Hotel hotel;

    public Service(){

    }

    public Service(String service_type, String hotel_id, double s_price) {
        this.service_type = service_type;
        this.hotel_id = hotel_id;
        this.s_price = s_price;
    }

    public Service(String hotel_id, double s_price) {
        this.hotel_id = hotel_id;
        this.s_price = s_price;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public double getS_price() {
        return s_price;
    }

    public void setS_price(double s_price) {
        this.s_price = s_price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Service{" +
                "service_type='" + service_type + '\'' +
                ", hotel_id='" + hotel_id + '\'' +
                ", s_price=" + s_price +
                '}';
    }
}
