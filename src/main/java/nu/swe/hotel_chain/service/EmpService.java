package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.Employee;
import nu.swe.hotel_chain.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    private final EmpRepository empRepository;

    @Autowired
    public EmpService(EmpRepository empRepository){
        this.empRepository = empRepository;
    }

    public List<Employee> getEmployees(){
        return this.empRepository.findAll();
    }

    public List<Employee> getEmployeeByEmail(String email) {
        return this.empRepository.findEmployeeByE_email(email);
    }

    public List<Employee> getEmployeeByRole(String role) {
        return this.empRepository.findEmployeeByE_email(role);
    }
}
