package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Employee;
import nu.swe.hotel_chain.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

    // manager dashboard. Selects all employees that are not managers
    @Query(value =
            "SELECT * FROM" +
                    " employee WHERE e_category <> 'Manager' ", nativeQuery = true
    )
    List<Employee> selectManagerDashboard();

}
