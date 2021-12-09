package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.RoomType;
import nu.swe.hotel_chain.service.RoomTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/room_types")
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping
    public List<RoomType> getRoomTypes(){
        return this.roomTypeService.getRoomTypes();
    }

    @GetMapping(path = "hotel/{hotel_id}")
    public List<RoomType> getRoomTypesByHotel_id(@PathVariable("hotel_id") String hotel_id){
        return this.roomTypeService.getRoomTypesByHotel_Id(hotel_id);
    }

    @GetMapping(path = "hotel/{hotel_id}/type/{r_type}")
    public List<RoomType> getRoomTypesByHotel_idAndByR_Type(@PathVariable("hotel_id") String hotel_id, @PathVariable("r_type") String r_type){
        return this.roomTypeService.getRoomTypesByHotel_idAndByR_Type(hotel_id, r_type);
    }
}
