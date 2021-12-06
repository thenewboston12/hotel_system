package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Hotel;
import nu.swe.hotel_chain.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/hotel")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    // GETS ALL HOTELS
    public List<Hotel> getHotels(){
        return hotelService.getHotels();
    }

    @GetMapping(path = "{hotel_id}")
    @ResponseStatus(HttpStatus.OK)
    // GET HOTEL BY ID
    public List<Hotel> getHotel(@PathVariable("hotel_id") String hotel_id){
        return hotelService.getHotel(hotel_id);
    }

    @GetMapping(path = "/availabe")
    // GET AVAILABLE HOTELS FROM DESTINATION CITY AND DATES, Example: api/hotel/available?destination="Almaty"&check_in="25-12-2021"&check_out="29-12-2021"
    public List<Hotel> getAvailableHotelsByCityAndDates(@RequestParam(required = true) String destination,
                                                        @RequestParam(required = true) String r_type,
                                                        @RequestParam(required = true)String check_in,
                                                        @RequestParam(required = true) String check_out){
        LocalDate check_in_date = LocalDate.parse(check_in);
        LocalDate check_out_date = LocalDate.parse(check_out);
        return hotelService.getAvailableHotelsByCityAndDates(destination, r_type, check_in_date, check_out_date);
    };
}
