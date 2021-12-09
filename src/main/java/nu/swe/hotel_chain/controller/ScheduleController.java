package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Schedule;
import nu.swe.hotel_chain.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Schedule> getSchedules(){
        return this.scheduleService.getSchedules();
    }

    @GetMapping(path = "employee/{employee_id}")
    public List<Schedule> getSchedulesByEmployee_id(@PathVariable("employee_id") Integer employee_id){
        return this.scheduleService.getSchedulesByEmployee_id(employee_id);
    }

    @GetMapping(path = "hotel_id/{hotel_id}/room_number/{r_number}")
    public List<Schedule> getSchedulesByHotel_idAndR_number(@PathVariable("hotel_id") String hotel_id, @PathVariable("r_number") Integer r_number){
        return this.scheduleService.getSchedulesByHotel_idAndR_number(hotel_id, r_number);
    }

    @PostMapping(path = "create")
    public ResponseEntity<Map<String, String>> createSchedule(@RequestBody Schedule schedule){
        Map<String, String> map = new HashMap<>();
        if(!this.scheduleService.createSchedule(schedule)){
            map.put("message", "Creation was unsuccessful");
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("message", "Successfully created schedule");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PutMapping(path = "employee/{employee_id}/hotel_id/{hotel_id}/room_number/{r_number}/edit")
    public ResponseEntity<Map<String, String>> editSchedule(@PathVariable("employee_id") Integer employee_id,
                                                            @PathVariable("hotel_id") String hotel_id,
                                                            @PathVariable("r_number") Integer r_number,
                                                            @RequestParam(required = false) Integer new_employee_id,
                                                            @RequestParam(required = false) Integer new_r_number,
                                                            @RequestParam(required = false) String new_hotel_id,
                                                            @RequestParam(required = false) Timestamp start_time,
                                                            @RequestParam(required = false) Timestamp end_time) {
        Map<String, String> map = new HashMap<>();
        System.out.println(start_time);
        if(!this.scheduleService.editSchedule(employee_id, hotel_id, r_number, new_employee_id, new_r_number, new_hotel_id, start_time, end_time)){
            map.put("message", "Edition was unsuccessful");
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("message", "Successfully edited schedule");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
