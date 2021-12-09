package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.exceptions.IllegalIdException;
import nu.swe.hotel_chain.models.Hotel;
import nu.swe.hotel_chain.models.RoomType;
import nu.swe.hotel_chain.models.RoomTypeId;
import nu.swe.hotel_chain.repository.HotelRepository;
import nu.swe.hotel_chain.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public RoomTypeService(RoomTypeRepository roomTypeRepository, HotelRepository hotelRepository) {
        this.roomTypeRepository = roomTypeRepository;
        this.hotelRepository = hotelRepository;
    }

    public List<RoomType> getRoomTypes(){
        return this.roomTypeRepository.findAll();
    }

    public List<RoomType> getRoomTypesByHotel_Id(String hotel_id) {
        Optional<Hotel> hotelOptional = this.hotelRepository.findById(hotel_id);
        if(!hotelOptional.isPresent()){
            throw new IllegalIdException("There is no hotel with such id " + hotel_id);
        }
        return this.roomTypeRepository.findByHotel_id(hotel_id);
    }

    public List<RoomType> getRoomTypesByHotel_idAndByR_Type(String hotel_id, String r_type) {
        Optional<RoomType> roomTypeOptional = this.roomTypeRepository.findById(new RoomTypeId(hotel_id, r_type));
        if(!roomTypeOptional.isPresent()){
            throw new IllegalIdException("There is no hotel with such id " + hotel_id);
        }
        return List.of(roomTypeOptional.get());
    }
}
