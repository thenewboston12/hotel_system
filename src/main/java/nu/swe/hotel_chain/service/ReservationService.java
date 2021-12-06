package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.Reservation;
import nu.swe.hotel_chain.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservations(){
        return this.reservationRepository.findAll();
    }
}
