package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query(value = "select case when count (R) > 0 then true else false end from Reservation as R where R.guest_id = ?1")
    public boolean existsByGuestId(int guest_id);

    @Query(value = "select case when count (R) > 0 then true else false end from Reservation as R where R.guest_id = ?1 and R.hotel_id = ?2")
    public boolean existsByIdAndHotel_id(int res_id, String hotel_id);

    @Query(value = "select R.hotel_id from Reservation as R where R.res_id = ?1")
    public String findHotel_idById(int res_id);
}
