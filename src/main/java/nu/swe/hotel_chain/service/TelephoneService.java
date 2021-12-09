package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.exceptions.IllegalIdException;
import nu.swe.hotel_chain.models.Hotel;
import nu.swe.hotel_chain.models.Telephone;
import nu.swe.hotel_chain.repository.HotelRepository;
import nu.swe.hotel_chain.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelephoneService {
    private final TelephoneRepository telephoneRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public TelephoneService(TelephoneRepository telephoneRepository, HotelRepository hotelRepository) {
        this.telephoneRepository = telephoneRepository;
        this.hotelRepository = hotelRepository;
    }

    public List<Telephone> getTelephones(){
        return this.telephoneRepository.findAll();
    }

    public List<Telephone> getTelephonesByHotel_id(String hotel_id) {
        Optional<Hotel> hotelOptional = this.hotelRepository.findById(hotel_id);
        if(hotelOptional.isEmpty()){
            throw new IllegalIdException("There is no hotel with such id " + hotel_id);
        }
        return this.telephoneRepository.findByHotel_id(hotel_id);
    }
}
