package nu.swe.hotel_chain.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hotelroomtype")
public class RoomType implements Serializable {
    /*Fields*/
    @Id
    @Column(name = "hotel_id")
    private String hotel_id;

    @Id
    @Column(name = "r_type")
    private Long r_type;

    @Column(name = "size")
    private double size;

    @Column(name = "capacity")
    private int capacity;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "hotel_id", nullable = false, unique = true)
    private Hotel hotel;


}
