package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Bill;
import nu.swe.hotel_chain.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/bills")
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    //GET ALL BILLS
    public List<Bill> getBills(){
        return this.billService.getBills();
    }
}
