package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.Guest;
import nu.swe.hotel_chain.models.Users;
import nu.swe.hotel_chain.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewGuest(Guest guest) {
        // COMMENT: since guest email is checked against users email then this validation is not needed
//        Optional<Guest> guestByEmail = guestRepository.findGuestByEmail(guest.getgEmail());
//        // check if email is not taken
//        if ( guestByEmail.isPresent()){
//            throw new IllegalStateException("email already exists for guest");
//        }
        guestRepository.save(guest);

    }
}
