package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Employee;
import nu.swe.hotel_chain.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/employees")
public class EmpController {
    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return this.empService.getEmployees();
    }

    @GetMapping(path = "email/{{email}}")
    public List<Employee> getEmployeeByEmail(@PathVariable("email") String email){
        return this.empService.getEmployeeByEmail(email);
    }

    @GetMapping(path = "role/{{role}}")
    public List<Employee> getEmployeeByRole(@PathVariable("role") String role){
        return this.empService.getEmployeeByRole(role);
    }
}
