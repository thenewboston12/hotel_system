package nu.swe.hotel_chain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "hotel_id", nullable = false, unique = true, insertable = false, updatable = false)
    @JsonBackReference
    private Hotel hotel;

    @OneToMany(mappedBy = "roomType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Room> rooms = new HashSet<>();

    public RoomType(){}

    public RoomType(String hotel_id, String r_type, double size, int capacity) {
        this.hotel_id = hotel_id;
        this.r_type = r_type;
        this.size = size;
        this.capacity = capacity;
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

    @Override
    public String toString() {
        return "RoomType{" +
                "hotel_id='" + hotel_id + '\'' +
                ", r_type='" + r_type + '\'' +
                ", size=" + size +
                ", capacity=" + capacity +
                ", rooms=" + rooms +
                '}';
    }
}
