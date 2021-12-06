package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Hotel;
import nu.swe.hotel_chain.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<Hotel> getHotels(){
        return hotelService.getHotels();
    }

    @GetMapping(path = "{hotel_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Hotel> getHotel(@PathVariable("hotel_id") String hotel_id){
        return hotelService.getHotel(hotel_id);
    }
}
