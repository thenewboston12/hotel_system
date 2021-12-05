package nu.swe.hotel_chain.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hotelphone")
public class Telephone implements Serializable {

    /*Fields*/
    @Id
    @Column(name = "hotel_id")
    private String hotel_id;

    @Id
    @Column(name = "h_phone")
    private String h_phone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    /*Constructors*/
    public Telephone(){

    }

    public Telephone(String hotel_id, String h_phone, Hotel hotel) {
        this.hotel_id = hotel_id;
        this.h_phone = h_phone;
        this.hotel = hotel;
    }


    public Telephone(String h_phone, Hotel hotel) {
        this.h_phone = h_phone;
        this.hotel = hotel;
    }

    /*Getters and Setters*/
    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getH_phone() {
        return h_phone;
    }

    public void setH_phone(String h_phone) {
        this.h_phone = h_phone;
    }

    /*ToString()*/
    @Override
    public String toString() {
        return "Telephone{\n" +
                "hotel_id=" + hotel_id +
                ",\n h_phone='" + h_phone + '\'' +
                "\n}\n";
    }
}
