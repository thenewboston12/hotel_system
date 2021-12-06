package nu.swe.hotel_chain.controller;

import nu.swe.hotel_chain.models.Employee;
import nu.swe.hotel_chain.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        return empService.getEmployees();
    }

    @GetMapping(path = "/manager")
    public List<Employee> getManagerDashboard(){
        return empService.getManagerDashboard();
    }

    // putmapping goes here


}
