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
}
