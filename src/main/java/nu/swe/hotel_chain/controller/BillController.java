package nu.swe.hotel_chain.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nu.swe.hotel_chain.models.Bill;
import nu.swe.hotel_chain.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    @GetMapping(path = "guest_id/{guest_id}/")
    public List<Bill> getBillsByGuest_id(@PathVariable("guest_id") String guest_id){
        Integer guest_id_int = Integer.parseInt(guest_id);
        return this.billService.getBillsByGuest_id(guest_id_int);
    }

    @GetMapping(path = "guest_id/{guest_id}/res_id/{res_id}")
    public List<Bill> getBillsByGuest_idAndRes_id(@PathVariable("guest_id") String guest_id, @PathVariable("res_id") String res_id){
        Integer res_id_int = Integer.parseInt(res_id);
        Integer guest_id_int = Integer.parseInt(guest_id);
        return this.billService.getBillsByGuest_idAndRes_id(guest_id_int, res_id_int);
    }

    @PostMapping(path = "creteBillForService")
    public void createNewBillForService(@RequestBody String json){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(json);
            int res_id = jsonNode.get("res_id").asInt();
            String hotel_id = "";
            String service_type = jsonNode.get("service_type").asText();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Bill bill = new Bill(res_id, hotel_id, service_type, 0, timestamp);
            System.out.println(bill);
            this.billService.createNewBillForService(bill);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @PostMapping(path = "creteBillForCheckOut")
    public void createNewBillForCheckout(@RequestBody String json){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(json);
            int res_id = jsonNode.get("res_id").asInt();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Bill bill = new Bill(res_id, "", "Check_out", 0, timestamp);
            System.out.println(bill);
            this.billService.createNewBillForCheckout(bill);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
