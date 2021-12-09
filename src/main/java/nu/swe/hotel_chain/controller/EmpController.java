package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Employee;
import nu.swe.hotel_chain.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "api/employees")
public class EmpController {
    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping
    // api/employees
    public List<Employee> getEmployees(){
        return this.empService.getEmployees();
    }

    @GetMapping(path = "email/{email}")
    // api/employees/email/{email}
    public List<Employee> getEmployeeByEmail(@PathVariable("email") String email){
        return this.empService.getEmployeeByEmail(email);
    }

    @GetMapping(path = "role/{role}")
    // api/employees/role/{role}
    public List<Employee> getEmployeeByRole(@PathVariable("role") String role){
        return this.empService.getEmployeeByRole(role);
    }

    @PutMapping(path = "email/{email}/adjustHours")
    // api/employees/email/{email}/adjustHours?hours=
    // Pass Hours request variable
    public ResponseEntity<Map<String, String>> updateHours(@PathVariable("email") String email,
                                                           @RequestParam(required = false) Integer hours,
                                                           @RequestParam(required = false) Integer salary){
        Map<String, String> map = new HashMap<>();
        if (!this.empService.updateHours(email, hours, salary)){
            map.put("message", "Update was unsuccessful");
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("message", "Update was successful");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
