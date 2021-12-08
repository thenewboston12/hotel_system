package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.Service;
import nu.swe.hotel_chain.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getServices(){
        return this.serviceRepository.findAll();
    }
}
