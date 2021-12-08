package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.exceptions.IllegalIdException;
import nu.swe.hotel_chain.exceptions.NotAvailableRoomException;
import nu.swe.hotel_chain.models.*;
import nu.swe.hotel_chain.repository.GuestRepository;
import nu.swe.hotel_chain.repository.HotelRepository;
import nu.swe.hotel_chain.repository.ReservationRepository;
import nu.swe.hotel_chain.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, GuestRepository guestRepository, HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    public List<Reservation> getReservations(){
        return this.reservationRepository.findAll();
    }

    public List<Reservation> getReservationById(Integer res_id) {
        Optional<Reservation> optionalReservation = this.reservationRepository.findById(res_id);
        if(!optionalReservation.isPresent()){
            throw new IllegalIdException("There is no reservation with id " + res_id);
        }
        return List.of(optionalReservation.get());
    }

    public List<Reservation> getReservationByHotelId(String hotel_id) {
        Optional<Hotel> optionalHotel = this.hotelRepository.findById(hotel_id);
        if (!optionalHotel.isPresent()){
            throw new IllegalIdException("There is no hotel with id " + hotel_id);
        }
        return this.reservationRepository.findByHotel_Id(hotel_id);
    }

    public List<Reservation> getReservationByGuestId(Integer guest_id) {
        Optional<Guest> optionalGuest = this.guestRepository.findById(guest_id);
        if(!optionalGuest.isPresent()){
            throw new IllegalIdException("There is no guest with id " + guest_id);
        }
        return this.reservationRepository.findByGuest_Id(guest_id);
    }

    public boolean createNewReservation(Reservation reservation) {
        Optional<Hotel> optionalHotel = this.hotelRepository.findById(reservation.getHotel_id());
        if (!optionalHotel.isPresent()){
            throw new IllegalIdException("There is no hotel with id " + reservation.getHotel_id());
        }

        Optional<Guest> optionalGuest = this.guestRepository.findById(reservation.getGuest_id());
        if(!optionalGuest.isPresent()){
            throw new IllegalIdException("There is no guest with id " + reservation.getGuest_id());
        }

        Optional<Room> optionalRoom = this.roomRepository.findById(new RoomId(reservation.getR_number(), reservation.getHotel_id()));
        if (!optionalRoom.isPresent()){
            throw new IllegalIdException("There is no room with number " + reservation.getR_number() + " in a hotel with " + reservation.getHotel_id());
        }

        boolean available = this.reservationRepository.checkAvailabilityByR_numberAndDate(reservation.getR_number(), reservation.getHotel_id(), reservation.getCheck_in());
        if (!available){
            throw new NotAvailableRoomException("The room " + reservation.getR_number() + " in a hotel with id " + reservation.getHotel_id() + " is not available for date " + reservation.getCheck_in());
        }

        available = this.reservationRepository.checkAvailabilityByR_numberAndDate(reservation.getR_number(), reservation.getHotel_id(), reservation.getCheck_out());
        if (!available){
            throw new NotAvailableRoomException("The room " + reservation.getR_number() + " in a hotel with id " + reservation.getHotel_id() + " is not available for date " + reservation.getCheck_out());
        }

        this.reservationRepository.save(reservation);

        return true;
    }

    public boolean deleteReservation(Integer res_id) {
        Optional<Reservation> optionalReservation = this.reservationRepository.findById(res_id);
        if(!optionalReservation.isPresent()){
            throw new IllegalIdException("There is no reservation with id " + res_id);
        }
        this.reservationRepository.deleteByRes_id(res_id);
        return true;
    }
}
