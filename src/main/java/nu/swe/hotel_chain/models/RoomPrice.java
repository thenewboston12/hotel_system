package nu.swe.hotel_chain.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roomprice")
@IdClass(RoomPriceId.class)
public class RoomPrice implements Serializable {
    @Id
    @Column(name = "hotel_id")
    private String hotel_id;

    @Id
    @Column(name = "r_type")
    private String r_type;

    @Column(name = "monday")
    private Float monday;

    @Column(name = "tuesday")
    private Float tuesday;

    @Column(name = "wednesday")
    private Float wednesday;

    @Column(name = "thursday")
    private Float thursday;

    @Column(name = "friday")
    private Float friday;

    @Column(name = "saturday")
    private Float saturday;

    @Column(name = "sunday")
    private Float sunday;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id", insertable = false, updatable = false),
            @JoinColumn(name = "r_type", referencedColumnName = "r_type", insertable = false, updatable = false)
    })
    @JsonBackReference
    private RoomType room_type;

    public RoomPrice() {
    }

    public RoomPrice(String hotel_id, String r_type, Float monday, Float tuesday, Float wednesday, Float thursday, Float friday, Float saturday, Float sunday) {
        this.hotel_id = hotel_id;
        this.r_type = r_type;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public RoomPrice(String r_type, Float monday, Float tuesday, Float wednesday, Float thursday, Float friday, Float saturday, Float sunday) {
        this.r_type = r_type;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getR_type() {
        return r_type;
    }

    public void setR_type(String r_type) {
        this.r_type = r_type;
    }

    public Float getModay() {
        return monday;
    }

    public void setModay(Float moday) {
        this.monday = moday;
    }

    public Float getTuesday() {
        return tuesday;
    }

    public void setTuesday(Float tuesday) {
        this.tuesday = tuesday;
    }

    public Float getWednesday() {
        return wednesday;
    }

    public void setWednesday(Float wednesday) {
        this.wednesday = wednesday;
    }

    public Float getThursday() {
        return thursday;
    }

    public void setThursday(Float thursday) {
        this.thursday = thursday;
    }

    public Float getFriday() {
        return friday;
    }

    public void setFriday(Float friday) {
        this.friday = friday;
    }

    public Float getSaturday() {
        return saturday;
    }

    public void setSaturday(Float saturday) {
        this.saturday = saturday;
    }

    public Float getSunday() {
        return sunday;
    }

    public void setSunday(Float sunday) {
        this.sunday = sunday;
    }

    public Float getMonday() {
        return monday;
    }

    public void setMonday(Float monday) {
        this.monday = monday;
    }

    public RoomType getRoom_type() {
        return room_type;
    }

    public void setRoom_type(RoomType room_type) {
        this.room_type = room_type;
    }

    @Override
    public String toString() {
        return "RoomPrice{" +
                "hotel_id='" + hotel_id + '\'' +
                ", r_type='" + r_type + '\'' +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", saturday=" + saturday +
                ", sunday=" + sunday +
                ", room_type=" + room_type +
                '}';
    }
}

