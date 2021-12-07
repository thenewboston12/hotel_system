package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.Room;
import nu.swe.hotel_chain.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms(){
        return this.roomRepository.findAll();
    }

    public List<Room> getRoomByHotelId(String hotel_id){
        return this.roomRepository.findRoomByHotel_id(hotel_id);
    }

    public List<Room> getRoomByRoomType(String r_type) {
        return this.roomRepository.findRoomByR_type(r_type);
    }

    public List<Room> getRoomByHotelIdAndR_Type(String hotel_id, String r_type) {
        return this.roomRepository.findRoomByHotel_idAndR_type(hotel_id, r_type);
    }

    public List<Room> getAvailableRoomBetweenDatesAndByHotel_IdAndR_Type(String hotel_id, String r_type,
                                                                         LocalDate check_in_date, LocalDate check_out_date) {
        return this.roomRepository.findAvailableRoomsInHotelWithR_Type(hotel_id, r_type, check_in_date, check_out_date);
    }
}
