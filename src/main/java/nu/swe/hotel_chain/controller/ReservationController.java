package nu.swe.hotel_chain.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nu.swe.hotel_chain.models.Reservation;
import nu.swe.hotel_chain.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    // api/reservations/
    public List<Reservation> getReservations(){
        return this.reservationService.getReservations();
    }

    @GetMapping(path = "res_id/{res_id}")
    @ResponseStatus(HttpStatus.OK)
    // api/reservations/res_id/{res_id}
    public List<Reservation> getReservationById(@PathVariable("res_id") Integer res_id){
        return this.reservationService.getReservationById(res_id);
    }

    @GetMapping(path = "hotel_id/{hotel_id}")
    @ResponseStatus(HttpStatus.OK)
    // api/reservations/hotel_id/{hotel_id}
    public List<Reservation> getReservationByHotelId(@PathVariable("hotel_id") String hotel_id){
        return this.reservationService.getReservationByHotelId(hotel_id);
    }

    @GetMapping(path = "guest_id/{guest_id}")
    @ResponseStatus(HttpStatus.OK)
    // api/reservations/guest_id/{guest_id}
    public List<Reservation> getReservationByGuestId(@PathVariable("guest_id") Integer guest_id){
        return this.reservationService.getReservationByGuestId(guest_id);
    }

    @PostMapping(path = "create")
    // api/reservations/create
    public ResponseEntity<Map<String, String>> createNewReservation(@RequestBody String json){
        Map<String, String> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            JsonNode jsonNode = mapper.readTree(json);
            int guest_id = jsonNode.get("guest_id").asInt();
            String hotel_id = jsonNode.get("hotel_id").asText();
            String r_type = jsonNode.get("r_type").asText();
            LocalDate check_in = LocalDate.parse(jsonNode.get("check_in").asText());
            LocalDate check_out = LocalDate.parse(jsonNode.get("check_out").asText());
            Reservation reservation = new Reservation(guest_id, hotel_id, 0, check_in, check_out);
            this.reservationService.createNewReservation(reservation, r_type);
        }catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("message", "reservation was created successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping(path = "res_id/{res_id}/delete")
    // api/reservations/{res_id}/delete
    public ResponseEntity<Map<String, String>> deleteReservationById(@PathVariable("res_id") Integer res_id){
        Map<String, String> map = new HashMap<>();
        if(!this.reservationService.deleteReservation(res_id)){
            map.put("message", "reservation deletion was unsuccessful");
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("message", "reservation deleted successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PutMapping(path = "res_id/{res_id}/edit")
    // api/reservations/{res_id}/edit
    public ResponseEntity<Map<String, String>> updateReservationById(@PathVariable("res_id") Integer res_id,
                                                                     @RequestParam(required = false) Integer r_number,
                                                                     @RequestParam(required = false) String check_in,
                                                                     @RequestParam(required = false) String check_out){
        Map<String, String> map = new HashMap<>();
        LocalDate check_in_date = LocalDate.parse(check_in);
        LocalDate check_out_date = LocalDate.parse(check_out);
        if(!this.reservationService.editReservation(res_id, r_number, check_in_date, check_out_date)){
            map.put("message", "reservation edition was unsuccessful");
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("message", "reservation edited successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
