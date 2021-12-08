package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Guest;
import nu.swe.hotel_chain.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

    @Query("SELECT g FROM Guest g WHERE g.gEmail = ?1")
    Optional<Guest> findGuestByEmail(String email);

}
