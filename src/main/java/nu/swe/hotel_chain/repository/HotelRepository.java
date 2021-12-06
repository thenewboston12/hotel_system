package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
    @Query(value = "SELECT H FROM Hotel as H WHERE H.hotel_id = ?1")
    List<Hotel> findByHotel_id(String hotel_id);
}
