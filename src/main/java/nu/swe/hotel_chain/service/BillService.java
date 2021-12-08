package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.Bill;
import nu.swe.hotel_chain.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> getBills(){
        return this.billRepository.findAll();
    }

    public List<Bill> getBill(Integer bill_id) {
        return this.billRepository.findByBill_id(bill_id);
    }

    public List<Bill> getBillsByRes_id(Integer res_id_int) {
        return this.billRepository.findByRes_id(res_id_int);
    }

    public void createNewBillForService(Bill bill) {
        this.billRepository.save(bill);
    }

    public List<Bill> getBillsByGuest_idAndRes_id(Integer guest_id_int, Integer res_id_int) {
        return this.billRepository.findByGuest_idAndRes_id(guest_id_int, res_id_int);
    }

    public List<Bill> getBillsByGuest_id(Integer guest_id_int) {
        return this.billRepository.findByGuest_id(guest_id_int);
    }
}
