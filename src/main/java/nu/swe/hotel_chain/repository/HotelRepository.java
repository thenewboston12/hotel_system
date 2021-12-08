package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
    @Query(value = "SELECT H FROM Hotel as H WHERE H.hotel_id = ?1")
    List<Hotel> findByHotel_id(String hotel_id);

    //Select hotels which has available rooms by destination and room type
    @Query(value =
            "SELECT H FROM Hotel AS H where H.h_city = ?1 AND exists (" + 
                    "SELECT R from  Room as R WHERE R.hotel_id=H.hotel_id and R.r_type = ?2 and exists (" +
                        "SELECT RS FROM Reservation as RS where RS.hotel_id=H.hotel_id and " +
                        "(?3 not between RS.check_in and RS.check_out) and " +
                        "(?4 not between RS.check_in and RS.check_out)" +
                    ")" +
            ")"
    )
    List<Hotel> findAvailableHotels(String destination, String r_type, LocalDate check_in, LocalDate check_out);

    @Query(value = "select H from Hotel as H where H.h_city = ?1")
    List<Hotel> findByCity(String city);
}
