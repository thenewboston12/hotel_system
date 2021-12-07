package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Bill;
import nu.swe.hotel_chain.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "{bill_id}")
    public List<Bill> getBill(@PathVariable("bill_id") String bill_id){
        Integer bill_id_int = Integer.parseInt(bill_id);
        return this.billService.getBill(bill_id_int);
    }

    @GetMapping(path = "res_id/{res_id}")
    public List<Bill> getBillsByRes_id(@PathVariable("res_id") String res_id){
        Integer res_id_int = Integer.parseInt(res_id);
        return this.billService.getBillsByRes_id(res_id_int);
    }

    @PostMapping(path = "creteBillForService")
    public void createNewBillForService(@RequestBody Bill bill){
        this.billService.createNewBillForService(bill);
    }
}
