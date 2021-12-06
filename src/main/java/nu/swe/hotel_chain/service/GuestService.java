package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.Guest;
import nu.swe.hotel_chain.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuests(){
        return this.guestRepository.findAll();
    }
}
