package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Service;
import nu.swe.hotel_chain.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/services")
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<Service> getServices(){
        return this.serviceService.getServices();
    }

    @GetMapping(path = "hotel/{hotel_id}")
    public List<Service> getServicesByHotel_id(@PathVariable("hotel_id") String hotel_id){
        return this.serviceService.getServicesByHotel_id(hotel_id);
    }

    @GetMapping(path = "hotel/{hotel_id}/service/{service_type}")
    public List<Service> getServicesByHotel_idAndService_type(@PathVariable("hotel_id") String hotel_id,
                                                              @PathVariable("service_type") String service_type){
        return this.serviceService.getServicesByHotel_idAndService_type(hotel_id, service_type);
    }
}
