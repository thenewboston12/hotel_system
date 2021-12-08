package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.exceptions.IllegalIdException;
import nu.swe.hotel_chain.models.Hotel;
import nu.swe.hotel_chain.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getHotels(){
        return this.hotelRepository.findAll();
    }

    public List<Hotel> getHotel(String hotel_id){
        boolean exists = this.hotelRepository.existsById(hotel_id);
        if(!exists){
            throw new IllegalIdException("Hotel with id " + hotel_id + " does not exist");
        }
        return this.hotelRepository.findByHotel_id(hotel_id);
    }

    public  List<Hotel> getAvailableHotelsByCityAndDates(String destination, String r_type, LocalDate check_in, LocalDate check_out){
        return this.hotelRepository.findAvailableHotels(destination, r_type, check_in, check_out);
    }

    public List<Hotel> getHotelByCity(String city) {
        return this.hotelRepository.findByCity(city);
    }
}
