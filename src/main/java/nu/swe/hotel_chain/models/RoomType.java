package nu.swe.hotel_chain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hotelroomtype")
@IdClass(RoomTypeId.class)
public class RoomType implements Serializable {
    /*Fields*/
    @Id
    @Column(name = "hotel_id")
    private String hotel_id;

    @Id
    @Column(name = "r_type")
    private String r_type;

    @Column(name = "size")
    private double size;

    @Column(name = "capacity")
    private int capacity;

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

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "hotel_id", nullable = false, unique = true, insertable = false, updatable = false)
    @JsonBackReference
    private Hotel hotel;

    @OneToMany(mappedBy = "roomType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Room> rooms = new HashSet<>();

    public RoomType(){}

    public RoomType(String hotel_id, String r_type, double size, int capacity, Float monday, Float tuesday, Float wednesday, Float thursday, Float friday, Float saturday, Float sunday) {
        this.hotel_id = hotel_id;
        this.r_type = r_type;
        this.size = size;
        this.capacity = capacity;
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Float getMonday() {
        return monday;
    }

    public void setMonday(Float monday) {
        this.monday = monday;
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

    @Override
    public String toString() {
        return "RoomType{" +
                "hotel_id='" + hotel_id + '\'' +
                ", r_type='" + r_type + '\'' +
                ", size=" + size +
                ", capacity=" + capacity +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", saturday=" + saturday +
                ", sunday=" + sunday +
                ", hotel=" + hotel +
                ", rooms=" + rooms +
                '}';
    }
}
