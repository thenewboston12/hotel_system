package nu.swe.hotel_chain.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Room_Type")
public class RoomType {
    @Id
    private Long room_type_id;
}
