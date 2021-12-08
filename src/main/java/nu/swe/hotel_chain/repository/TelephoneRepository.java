package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.TelehoneId;
import nu.swe.hotel_chain.models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, TelehoneId> {
}
