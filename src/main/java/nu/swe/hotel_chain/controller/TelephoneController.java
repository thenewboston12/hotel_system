package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Telephone;
import nu.swe.hotel_chain.service.TelephoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/telephones")
public class TelephoneController {
    private final TelephoneService telephoneService;

    public TelephoneController(TelephoneService telephoneService) {
        this.telephoneService = telephoneService;
    }

    @GetMapping
    public List<Telephone> getTelephones(){
        return this.telephoneService.getTelephones();
    }

    @GetMapping(path = "hotel/{hotel_id}")
    public List<Telephone> getTelephonesByHotel_id(@PathVariable("hotel_id") String hotel_id){
        return this.telephoneService.getTelephonesByHotel_id(hotel_id);
    }
}
