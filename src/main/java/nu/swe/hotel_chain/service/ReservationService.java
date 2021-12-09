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

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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

    public boolean createNewReservation(Reservation reservation, String r_type) {
        Optional<Hotel> optionalHotel = this.hotelRepository.findById(reservation.getHotel_id());
        if (!optionalHotel.isPresent()){
            throw new IllegalIdException("There is no hotel with id " + reservation.getHotel_id());
        }

        Optional<Guest> optionalGuest = this.guestRepository.findById(reservation.getGuest_id());
        if(!optionalGuest.isPresent()){
            throw new IllegalIdException("There is no guest with id " + reservation.getGuest_id());
        }

        List<Room> rooms = this.roomRepository.findAvailableRoomsInHotelWithR_Type(reservation.getHotel_id(), r_type, reservation.getCheck_in(), reservation.getCheck_out());
        if(rooms.size() == 0){
            throw new NotAvailableRoomException("There is no available rooms");
        }
        reservation.setR_number(rooms.get(0).getR_number());

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
        this.reservationRepository.deleteById(res_id);
        return true;
    }

    public boolean editReservation(Integer res_id, Integer r_number, LocalDate check_in, LocalDate check_out) {
        Optional<Reservation> optionalReservation = this.reservationRepository.findById(res_id);
        if(!optionalReservation.isPresent()){
            throw new IllegalIdException("There is no reservation with id " + res_id);
        }

        Reservation reservation = this.reservationRepository.findById(res_id).get();

        Optional<Room> optionalRoom = this.roomRepository.findById(new RoomId(r_number, reservation.getHotel_id()));
        if (!optionalRoom.isPresent()){
            throw new IllegalIdException("There is no room with number " + r_number + " in a hotel with " + reservation.getHotel_id());
        }
        if(r_number != null && r_number != 0 && !Objects.equals(reservation.getR_number(), r_number)){
            reservation.setR_number(r_number);
        }

        boolean available = this.reservationRepository.checkAvailabilityByR_numberAndDate(r_number, reservation.getHotel_id(), check_in);
        if (!available){
            throw new NotAvailableRoomException("The room " + r_number + " in a hotel with id " + reservation.getHotel_id() + " is not available for date " + check_in);
        }
        if(check_in != null && !Objects.equals(reservation.getCheck_in(), check_in)){
            reservation.setCheck_in(check_in);
        }

        available = this.reservationRepository.checkAvailabilityByR_numberAndDate(r_number, reservation.getHotel_id(), check_out);
        if (!available){
            throw new NotAvailableRoomException("The room " + r_number + " in a hotel with id " + reservation.getHotel_id() + " is not available for date " + check_out);
        }
        if(check_out != null && !Objects.equals(reservation.getCheck_out(), check_out)){
            reservation.setCheck_out(check_out);
        }

        this.reservationRepository.save(reservation);
        return true;
    }
}
