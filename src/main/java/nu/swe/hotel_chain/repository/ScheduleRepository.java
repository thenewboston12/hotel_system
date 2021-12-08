package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Schedule;
import nu.swe.hotel_chain.models.ScheduleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, ScheduleId> {
}
