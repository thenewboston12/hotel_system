package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Reservation;
import nu.swe.hotel_chain.models.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query(value = "select case when count (R) > 0 then true else false end from Reservation as R where R.guest_id = ?1")
    public boolean existsByGuestId(int guest_id);

    @Query(value = "select case when count (R) > 0 then true else false end from Reservation as R where R.guest_id = ?1 and R.hotel_id = ?2")
    public boolean existsByIdAndHotel_id(int res_id, String hotel_id);

    @Query(value = "select R.hotel_id from Reservation as R where R.res_id = ?1")
    public String findHotel_idById(int res_id);

    @Query(value = "" +
            "select RT from RoomType as RT where exists (" +
                "select R from Room as R where R.r_type = RT.r_type and R.hotel_id = RT.hotel_id and exists (" +
                "select RS from Reservation as RS where RS.r_number = R.r_number and RS.hotel_id = R.hotel_id and RS.res_id = ?1)" +
            ")"
    )
    public RoomType findRoomTypeById(int res_id);

    @Query(value = "select R.check_in from Reservation as R where R.res_id = ?1")
    public LocalDate findCheckInDateById(int res_id);

    @Query(value = "select R.check_out from Reservation as R where R.res_id = ?1")
    public LocalDate findCheckOutDateById(int res_id);
}
