package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.exceptions.IllegalIdException;
import nu.swe.hotel_chain.models.*;
import nu.swe.hotel_chain.repository.EmpRepository;
import nu.swe.hotel_chain.repository.HotelRepository;
import nu.swe.hotel_chain.repository.RoomRepository;
import nu.swe.hotel_chain.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final EmpRepository empRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, EmpRepository empRepository, HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.scheduleRepository = scheduleRepository;
        this.empRepository = empRepository;
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    public List<Schedule> getSchedules(){
        return this.scheduleRepository.findAll();
    }

    public List<Schedule> getSchedulesByEmployee_id(Integer employee_id) {
        Optional<Employee> employeeOptional = this.empRepository.findById(employee_id);
        if(!employeeOptional.isPresent()){
            throw new IllegalIdException("There is no employee with id " + employee_id);
        }
        return this.scheduleRepository.findByEmployee_id(employee_id);
    }

    public List<Schedule> getSchedulesByHotel_idAndR_number(String hotel_id, Integer r_number) {
        Optional<Hotel> hotelOptional = this.hotelRepository.findById(hotel_id);
        if(!hotelOptional.isPresent()){
            throw new IllegalIdException("There is no hotel id " + hotel_id);
        }

        Optional<Room> roomOptional = this.roomRepository.findById(new RoomId(r_number, hotel_id));
        if(!roomOptional.isPresent()){
            throw new IllegalIdException("There is no room in hotel id " + hotel_id + " room number " + r_number);
        }

        return this.scheduleRepository.findByHotel_idAndR_number(hotel_id, r_number);
    }

    public boolean createSchedule(Schedule schedule) {
        Integer employee_id = schedule.getEmployee_id();
        String hotel_id = schedule.getHotel_id();
        Integer r_number = schedule.getR_number();

        Optional<Employee> employeeOptional = this.empRepository.findById(employee_id);
        if(!employeeOptional.isPresent()){
            throw new IllegalIdException("There is no employee with id " + employee_id);
        }

        Optional<Hotel> hotelOptional = this.hotelRepository.findById(hotel_id);
        if(!hotelOptional.isPresent()){
            throw new IllegalIdException("There is no hotel id " + hotel_id);
        }

        Optional<Room> roomOptional = this.roomRepository.findById(new RoomId(r_number, hotel_id));
        if(!roomOptional.isPresent()){
            throw new IllegalIdException("There is no room in hotel id " + hotel_id + " room number " + r_number);
        }

        System.out.println(schedule);

        this.scheduleRepository.save(schedule);
        return true;
    }

    private boolean checkForValidity(Integer employee_id, String hotel_id, Integer r_number){
        Optional<Employee> employeeOptional = this.empRepository.findById(employee_id);
        if(employeeOptional.isEmpty()){
            throw new IllegalIdException("There is no employee with id " + employee_id);
        }

        Optional<Hotel> hotelOptional = this.hotelRepository.findById(hotel_id);
        if(hotelOptional.isEmpty()){
            throw new IllegalIdException("There is no hotel id " + hotel_id);
        }

        Optional<Room> roomOptional = this.roomRepository.findById(new RoomId(r_number, hotel_id));
        if(roomOptional.isEmpty()){
            throw new IllegalIdException("There is no room in hotel id " + hotel_id + " room number " + r_number);
        }
        return true;
    }

    public boolean editSchedule(Integer employee_id, String hotel_id, Integer r_number, Integer new_employee_id, Integer new_r_number, String new_hotel_id, Timestamp start_time, Timestamp end_time) {
        checkForValidity(employee_id, hotel_id, r_number);

        Schedule schedule = this.scheduleRepository.findById(new ScheduleId(employee_id, r_number, hotel_id)).get();

        if(new_employee_id != null && new_employee_id != 0 && Objects.equals(employee_id, new_employee_id)){
            Optional<Employee> newEmployeeOptional = this.empRepository.findById(new_employee_id);
            if(newEmployeeOptional.isEmpty()){
                throw new IllegalIdException("There is no employee with new id " + employee_id);
            }
            schedule.setEmployee_id(new_employee_id);
        }

        if(new_hotel_id != null && Objects.equals(hotel_id, new_hotel_id)){
            Optional<Hotel> newHotelOptional = this.hotelRepository.findById(new_hotel_id);
            if(newHotelOptional.isEmpty()){
                throw new IllegalIdException("There is no hotel id " + new_hotel_id);
            }
            schedule.setHotel_id(new_hotel_id);
        }

        if(new_r_number != null && new_r_number != 0 && Objects.equals(r_number, new_r_number)){
            Optional<Room> newRoomOptional = this.roomRepository.findById(new RoomId(new_r_number, schedule.getHotel_id()));
            if(newRoomOptional.isEmpty()){
                throw new IllegalIdException("There is no room in hotel id " + schedule.getHotel_id() + " room number " + new_r_number);
            }
            schedule.setR_number(new_r_number);
        }

        if(start_time != null && Objects.equals(schedule.getStart_time(), start_time)){
            schedule.setStart_time(start_time);
        }

        if(end_time != null && Objects.equals(schedule.getEnd_time(), end_time)){
            schedule.setEnd_time(end_time);
        }

        this.scheduleRepository.save(schedule);

        System.out.println(schedule);

        return true;
    }

    public boolean deleteSchedule(Integer employee_id, String hotel_id, Integer r_number) {
        checkForValidity(employee_id, hotel_id, r_number);
        this.scheduleRepository.deleteById(new ScheduleId(employee_id, r_number, hotel_id));
        return true;
    }
}
