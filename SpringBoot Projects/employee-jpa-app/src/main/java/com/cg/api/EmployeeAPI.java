package com.cg.api;

import com.cg.entity.Employee;
import com.cg.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeAPI {

    private final EmployeeRepository employeeRepository;

    public EmployeeAPI(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    @GetMapping
    public List<Employee> readAllEmps() {
        return employeeRepository.findAll();
    }

    @GetMapping("/search") //// url -  /api/employees/search?address=delhi
    public List<Employee> findByAddress(@RequestParam String address) {
        return employeeRepository.findByAddress(address);
    }
    //instagram.com/Anshu
    //     @GetMapping("/{id}")  // url -  /api/employees/101
    public ResponseEntity<Employee> readById(@PathVariable int id) {
         Optional<Employee>  employee=employeeRepository.findById(id);
         if(employee.isPresent()){
            Employee emp=employee.get();
             return ResponseEntity.ok(emp);
         }
         else {
             return ResponseEntity.notFound().build();
             
         }
       // return employeeRepository.findById(id)
               // .map(ResponseEntity::ok)
               //here ok returns Employee object in response body and status code 200
            //  .map(result-> ResponseEntity.ok(result)) 
            //  .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employeeRequest) {
        Optional<Employee> existingEmployee =   
        employeeRepository.findById(id);
             if(existingEmployee.isPresent() )  {
                Employee emp = existingEmployee.get();
                emp.setEmpName(employeeRequest.getEmpName());
                emp.setSalary(employeeRequest.getSalary());
                emp.setAddress(employeeRequest.getAddress());
                return employeeRepository.save(emp); //saved in DB        
             }
             else return null;
           }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmp(@PathVariable int id) {
          Optional<Employee> existingEmployee =    employeeRepository.findById(id);
          if(existingEmployee.isPresent() )  {
                employeeRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
    }

}

