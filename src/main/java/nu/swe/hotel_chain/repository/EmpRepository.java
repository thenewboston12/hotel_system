package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
