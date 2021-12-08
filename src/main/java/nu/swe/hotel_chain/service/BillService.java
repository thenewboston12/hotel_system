package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.exceptions.IllegalIdException;
import nu.swe.hotel_chain.models.Bill;
import nu.swe.hotel_chain.models.ServiceId;
import nu.swe.hotel_chain.repository.BillRepository;
import nu.swe.hotel_chain.repository.HotelRepository;
import nu.swe.hotel_chain.repository.ReservationRepository;
import nu.swe.hotel_chain.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    private final BillRepository billRepository;
    private final ReservationRepository reservationRepository;
    private final HotelRepository hotelRepository;
    private final ServiceRepository serviceRepository;

    @Autowired
    public BillService(BillRepository billRepository, ReservationRepository reservationRepository, HotelRepository hotelRepository, ServiceRepository serviceRepository) {
        this.billRepository = billRepository;
        this.reservationRepository = reservationRepository;
        this.hotelRepository = hotelRepository;
        this.serviceRepository = serviceRepository;
    }

    public List<Bill> getBills(){
        return this.billRepository.findAll();
    }

    public List<Bill> getBill(Integer bill_id) {
        boolean exists = this.billRepository.existsById(bill_id);
        if(!exists){
            throw new IllegalIdException("BIll with id " + bill_id + " does not exist");
        }
        return this.billRepository.findByBill_id(bill_id);
    }

    public List<Bill> getBillsByRes_id(Integer res_id_int) {
        boolean exists = this.reservationRepository.existsById(res_id_int);
        if(!exists){
            throw new IllegalIdException("Reservation with id " + res_id_int + " does not exist");
        }
        return this.billRepository.findByRes_id(res_id_int);
    }
    public void createNewBillForService(Bill bill) {
        boolean exists = this.reservationRepository.existsById(bill.getRes_id());
        if(!exists){
            throw new IllegalIdException("Reservation with id " + bill.getRes_id() + " does not exist");
        }

        String hotel_id = this.reservationRepository.findHotel_idById(bill.getRes_id());
        bill.setHotel_id(hotel_id);

        float servicePrice = this.serviceRepository.findS_priceByHotelIdAndService_type(bill.getHotel_id(), bill.getService_type());
        bill.setTotal_price(servicePrice);

        exists = this.serviceRepository.existsById(new ServiceId(bill.getService_type(), bill.getHotel_id()));
        if(!exists){
            throw new IllegalIdException("Service with type " + bill.getService_type() + " and hotel id " + bill.getHotel_id() + " does not exist");
        }

        System.out.println(bill);

        this.billRepository.save(bill);
    }

    public List<Bill> getBillsByGuest_idAndRes_id(Integer guest_id_int, Integer res_id_int) {
        boolean exists = this.reservationRepository.existsById(res_id_int);
        if(!exists){
            throw new IllegalIdException("Reservation with id " + res_id_int + " does not exist");
        }

        exists = this.reservationRepository.existsByGuestId(guest_id_int);
        if(!exists){
            throw new IllegalIdException("Guest with id " + guest_id_int + " does not exist");
        }

        return this.billRepository.findByGuest_idAndRes_id(guest_id_int, res_id_int);
    }

    public List<Bill> getBillsByGuest_id(Integer guest_id_int) {
        boolean exists = this.reservationRepository.existsByGuestId(guest_id_int);
        if(!exists){
            throw new IllegalIdException("Guest with id " + guest_id_int + " does not exist");
        }
        return this.billRepository.findByGuest_id(guest_id_int);
    }

    public void createNewBillForCheckout(Bill bill) {
        boolean exists = this.reservationRepository.existsById(bill.getRes_id());
        if(!exists){
            throw new IllegalIdException("Reservation with id " + bill.getRes_id() + " does not exist");
        }

        String hotel_id = this.reservationRepository.findHotel_idById(bill.getRes_id());
        bill.setHotel_id(hotel_id);

        float servicePrice = 0;
        bill.setTotal_price(servicePrice);

        exists = this.serviceRepository.existsById(new ServiceId(bill.getService_type(), bill.getHotel_id()));
        if(!exists){
            throw new IllegalIdException("Service with type " + bill.getService_type() + " and hotel id " + bill.getHotel_id() + " does not exist");
        }

        System.out.println(bill);

        this.billRepository.save(bill);
    }
}
