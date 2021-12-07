package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.RoomType;
import nu.swe.hotel_chain.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    public List<RoomType> getRoomTypes(){
        return this.roomTypeRepository.findAll();
    }
}
