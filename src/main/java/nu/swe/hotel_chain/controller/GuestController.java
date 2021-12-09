package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Guest;
import nu.swe.hotel_chain.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/guests")
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    // api/guests/
    public List<Guest> getGuests(){
        return this.guestService.getGuests();
    }

    @GetMapping(path = "email/{email}")
    // api/guests/email/{email}
    public List<Guest> getGuestByEmail(@PathVariable("email") String email){
        return this.guestService.getGuestByEmail(email);
    }
}
