package nu.swe.hotel_chain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "r_number")
    private int r_number;

    @Id
    @Column(name = "hotel_id")
    private String hotel_id;
    private String r_type;
    private int r_floor;
    private int price_id;
    private boolean isClean;
    private boolean isOccupied;
}
