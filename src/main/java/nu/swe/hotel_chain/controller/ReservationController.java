package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Reservation;
import nu.swe.hotel_chain.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
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
    public ResponseEntity<Map<String, String>> createNewReservation(@RequestBody Reservation reservation){
        Map<String, String> map = new HashMap<>();
        if(!this.reservationService.createNewReservation(reservation)){
            map.put("message", "reservation was unsuccessful");
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
}
