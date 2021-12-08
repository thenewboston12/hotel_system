package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.RoomType;
import nu.swe.hotel_chain.service.RoomTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}
