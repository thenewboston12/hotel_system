package nu.swe.hotel_chain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "room")
public class Room implements Serializable {
    @Id
    @Column(name = "r_number")
    private int r_number;

    @Id
    @Column(name = "hotel_id")
    private String hotel_id;

    @Column(name = "r_type")
    private String r_type;

    @Column(name = "r_floor")
    private int r_floor;

    @Column(name = "price_id")
    private int price_id;

    @Column(name = "is_clean")
    private boolean is_clean;

    @Column(name = "is_occupied")
    private boolean is_occupied;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumns({
            @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id", insertable = false, updatable = false),
            @JoinColumn(name = "r_type", referencedColumnName = "r_type", insertable = false, updatable = false)
    })
    @JsonBackReference
    private RoomType roomType;

    public int getR_number() {
        return r_number;
    }

    public void setR_number(int r_number) {
        this.r_number = r_number;
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

    public int getR_floor() {
        return r_floor;
    }

    public void setR_floor(int r_floor) {
        this.r_floor = r_floor;
    }

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public boolean isIs_clean() {
        return is_clean;
    }

    public void setIs_clean(boolean is_clean) {
        this.is_clean = is_clean;
    }

    public boolean isIs_occupied() {
        return is_occupied;
    }

    public void setIs_occupied(boolean is_occupied) {
        this.is_occupied = is_occupied;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "r_number=" + r_number +
                ", hotel_id='" + hotel_id + '\'' +
                ", r_type='" + r_type + '\'' +
                ", r_floor=" + r_floor +
                ", price_id=" + price_id +
                ", is_clean=" + is_clean +
                ", is_occupied=" + is_occupied +
                '}';
    }
}
