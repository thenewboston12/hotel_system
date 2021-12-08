package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.Schedule;
import nu.swe.hotel_chain.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getSchedules(){
        return this.scheduleRepository.findAll();
    }
}
