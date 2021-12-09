package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.exceptions.IllegalIdException;
import nu.swe.hotel_chain.models.*;
import nu.swe.hotel_chain.repository.HotelRepository;
import nu.swe.hotel_chain.repository.RoomRepository;
import nu.swe.hotel_chain.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final RoomTypeRepository roomTypeRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository, RoomTypeRepository roomTypeRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.roomTypeRepository = roomTypeRepository;
    }

    public List<Room> getRooms(){
        return this.roomRepository.findAll();
    }

    public List<Room> getRoomByHotelId(String hotel_id){
        Optional<Hotel> roomOptional = this.hotelRepository.findById(hotel_id);
        if (!roomOptional.isPresent()){
            throw new IllegalIdException("There is no hotel with id " + hotel_id);
        }
        return this.roomRepository.findRoomByHotel_id(hotel_id);
    }

    public List<Room> getRoomByRoomType(String r_type) {
        List<RoomType> roomTypeList = this.roomTypeRepository.findByR_type(r_type);
        if(roomTypeList.size() == 0){
            throw new IllegalIdException("There is no room types with type " + r_type);
        }
        return this.roomRepository.findRoomByR_type(r_type);
    }

    public List<Room> getRoomByHotelIdAndR_Type(String hotel_id, String r_type) {
        Optional<RoomType> roomTypeOptional = this.roomTypeRepository.findById(new RoomTypeId(hotel_id, r_type));
        if(!roomTypeOptional.isPresent()){
            throw new IllegalIdException("There is no rooms with hotel id " + hotel_id + " and r_type " + r_type);
        }
        return this.roomRepository.findRoomByHotel_idAndR_type(hotel_id, r_type);
    }

    public List<Room> getAvailableRoomBetweenDatesAndByHotel_IdAndR_Type(String hotel_id, String r_type,
                                                                         LocalDate check_in_date, LocalDate check_out_date) {
        Optional<RoomType> roomTypeOptional = this.roomTypeRepository.findById(new RoomTypeId(hotel_id, r_type));
        if(!roomTypeOptional.isPresent()){
            throw new IllegalIdException("There is no rooms with hotel id " + hotel_id + " and r_type " + r_type);
        }
        return this.roomRepository.findAvailableRoomsInHotelWithR_Type(hotel_id, r_type, check_in_date, check_out_date);
    }

    public boolean updateRoomStatuses(String hotel_id, Integer r_number, boolean changeOccupancy, boolean changeCleaning) {
        Optional<Room> roomOptional = this.roomRepository.findById(new RoomId(r_number, hotel_id));
        if(!roomOptional.isPresent()){
            throw new IllegalIdException("There is no rooms with hotel id " + hotel_id + " and number " + r_number);
        }
        Room room = roomOptional.get();
        if(changeOccupancy){
            room.setIs_occupied(!room.isIs_occupied());
        }
        if(changeCleaning){
            room.setIs_clean(!room.isIs_clean());
        }
        this.roomRepository.save(room);
        return true;
    }

    public List<Room> getRoomByHotelIdAndR_number(String hotel_id, Integer r_number) {
        Optional<Room> roomOptional = this.roomRepository.findById(new RoomId(r_number, hotel_id));
        if(!roomOptional.isPresent()){
            throw new IllegalIdException("There is no rooms with hotel id " + hotel_id + " and number " + r_number);
        }
        return List.of(roomOptional.get());
    }
}
