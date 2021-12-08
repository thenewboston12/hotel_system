package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Room;
import nu.swe.hotel_chain.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    // GETS ALL HOTELS
    public List<Room> getRooms(){
        return this.roomService.getRooms();
    }

    @GetMapping(path = "hotel/{hotel_id}")
    public List<Room> getRoomByHotelId(@PathVariable("hotel_id") String hotel_id){
        return this.roomService.getRoomByHotelId(hotel_id);
    }

    @GetMapping(path = "room_type/{r_type}")
    public List<Room> getRoomByRoomType(@PathVariable("r_type") String r_type){
        return this.roomService.getRoomByRoomType(r_type);
    }

    @GetMapping("hotel/{hotel_id}/{r_type}")
    public List<Room> getRoomByHotelIdAndR_Type(@PathVariable("hotel_id") String hotel_id,
                                                @PathVariable("r_type") String r_type){
        return this.roomService.getRoomByHotelIdAndR_Type(hotel_id, r_type);
    }

    @GetMapping("hotel/{hotel_id}/{r_type}/available")
    public List<Room> getAvailableRoomBetweenDatesAndByHotel_IdAndR_Type(@PathVariable("hotel_id") String hotel_id,
                                                                         @PathVariable("r_type") String r_type,
                                                                         @RequestParam(required = true) String check_in,
                                                                         @RequestParam(required = true) String check_out){
        LocalDate check_in_date = LocalDate.parse(check_in);
        LocalDate check_out_date = LocalDate.parse(check_out);
        return this.roomService.getAvailableRoomBetweenDatesAndByHotel_IdAndR_Type(hotel_id, r_type, check_in_date, check_out_date);
    }
}
