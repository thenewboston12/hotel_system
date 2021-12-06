package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
