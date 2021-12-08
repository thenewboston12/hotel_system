package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Room;
import nu.swe.hotel_chain.models.RoomId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, RoomId> {
    @Query(value = "select R from Room AS R where R.hotel_id = ?1")
    List<Room> findRoomByHotel_id(String hotel_id);

    @Query(value = "select R from Room AS R where R.r_type = ?1")
    List<Room> findRoomByR_type(String r_type);

    @Query(value = "select R from Room as R where R.hotel_id = ?1 and R.r_type = ?2")
    List<Room> findRoomByHotel_idAndR_type(String hotel_id, String r_type);

    @Query(value = "" +
            "select R from Room as R where R.hotel_id = ?1 and R.r_type = ?2 and exists (" +
                "select RS from Reservation as RS where RS.r_number = R.r_number and RS.hotel_id = R.hotel_id and " +
                "(?3 not between RS.check_in and RS.check_out) and (?4 not between RS.check_in and RS.check_out)" +
            ")"
    )
    List<Room> findAvailableRoomsInHotelWithR_Type(String hotel_id, String r_type,
                                                          LocalDate check_in_date, LocalDate check_out_date);
}
