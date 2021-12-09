package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.exceptions.IllegalIdException;
import nu.swe.hotel_chain.models.Hotel;
import nu.swe.hotel_chain.models.Service;
import nu.swe.hotel_chain.models.ServiceId;
import nu.swe.hotel_chain.repository.HotelRepository;
import nu.swe.hotel_chain.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository, HotelRepository hotelRepository) {
        this.serviceRepository = serviceRepository;
        this.hotelRepository = hotelRepository;
    }

    public List<Service> getServices(){
        return this.serviceRepository.findAll();
    }

    public List<Service> getServicesByHotel_id(String hotel_id) {
        Optional<Hotel> hotelOptional = this.hotelRepository.findById(hotel_id);
        if(!hotelOptional.isPresent()){
            throw new IllegalIdException("There is no hotel with id " + hotel_id);
        }
        return this.serviceRepository.findByHotel_id(hotel_id);
    }

    public List<Service> getServicesByHotel_idAndService_type(String hotel_id, String service_type) {
        Optional<Service> serviceOptional = this.serviceRepository.findById(new ServiceId(service_type, hotel_id));
        if(!serviceOptional.isPresent()){
            throw new IllegalIdException("There is no service with hotel id " + hotel_id + " service type " + service_type);
        }
        return List.of(serviceOptional.get());
    }
}
