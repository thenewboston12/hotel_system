package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Schedule;
import nu.swe.hotel_chain.models.ScheduleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, ScheduleId> {
    @Query(value = "select S from Schedule as S where S.employee_id = ?1")
    List<Schedule> findByEmployee_id(Integer employee_id);

    @Query(value = "select S from Schedule as S where S.hotel_id = ?1 and S.r_number = ?2")
    List<Schedule> findByHotel_idAndR_number(String hotel_id, Integer r_number);

    @Query(value = "select S from Schedule as S where S.hotel_id = ?1 and S.r_number = ?2 and S.employee_id = ?3")
    List<Schedule> findByAllIds(String hotel_id, Integer room_number, Integer employee_id);

}
