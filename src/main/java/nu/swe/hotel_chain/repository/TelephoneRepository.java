package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.TelehoneId;
import nu.swe.hotel_chain.models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, TelehoneId> {
    @Query(value = "select T from Telephone as T where T.hotel_id = ?1")
    List<Telephone> findByHotel_id(String hotel_id);
}
