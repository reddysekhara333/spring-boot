package com.spring.app.springfirstapp.Controller;

import com.spring.app.springfirstapp.Entity.Employee;
import com.spring.app.springfirstapp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public Employee storeEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);

    }
    @PostMapping("/addAll")
    public List<Employee> StoreEmployees(@RequestBody
                                         List<Employee> employees){
        return service.AddEmployees(employees);
    }
    @GetMapping("/getEmployee/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id){
        return service.getEmployee(id);
    }

    @GetMapping("/getEmployeeName/{name}")
    public Optional<Employee> getEmployee(@PathVariable String name){
        return service.getEmployeeName(name);
    }

    @GetMapping("/findAll")
    public List<Employee> getAllEmployees(){
        return service.getEmployees();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return service.DeleteEmployee(id);

    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee product){
//added a liness
        return service.updateEmployee(product);
    }
}
