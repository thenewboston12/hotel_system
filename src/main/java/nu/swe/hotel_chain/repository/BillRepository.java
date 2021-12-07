package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

    @Query(value = "select B from Bill as B where B.bill_id = ?1")
    public List<Bill> findByBill_id(Integer bill_id);

    @Query(value = "select B from Bill as B where B.res_id = ?1")
    public List<Bill> findByRes_id(Integer res_id);
}
