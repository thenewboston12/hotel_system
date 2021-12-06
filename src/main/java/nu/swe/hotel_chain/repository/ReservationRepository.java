package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Reservation;
import nu.swe.hotel_chain.models.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {

}
