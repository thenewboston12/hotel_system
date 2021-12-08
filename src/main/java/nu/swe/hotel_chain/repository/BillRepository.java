package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

    @Query(value = "select B from Bill as B where B.bill_id = ?1")
    List<Bill> findByBill_id(Integer bill_id);

    @Query(value = "select B from Bill as B where B.res_id = ?1")
    List<Bill> findByRes_id(Integer res_id);

    @Query(value = "select B from Bill as B where B.res_id= ?2 and exists (select R from Reservation as R where R.res_id = B.res_id and R.guest_id = ?1)")
    List<Bill> findByGuest_idAndRes_id(Integer guest_id, Integer res_id);

    @Query(value = "select B from Bill as B where exists (select R from Reservation as R where R.res_id = B.res_id and R.guest_id = ?1)")
    List<Bill> findByGuest_id(Integer guest_id);
}
