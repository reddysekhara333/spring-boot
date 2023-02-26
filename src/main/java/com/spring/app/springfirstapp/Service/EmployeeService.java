package com.spring.app.springfirstapp.Service;

import com.spring.app.springfirstapp.Entity.Employee;
import com.spring.app.springfirstapp.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(Employee employee){
        return repository.save(employee);

    }
    public List<Employee> AddEmployees(List<Employee> employee){
        return repository.saveAll(employee);
    }


    public Optional<Employee> getEmployee(Long id){
        return repository.findById(id);
    }
    public Optional<Employee> getEmployeeName(String name){
        return repository.findByName(name);
    }
    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    public String DeleteEmployee(Long id){
        repository.deleteById(id);
       return "delete By id is"+id;

    }

    public Employee updateEmployee(Employee employee){
        Employee em=repository.findById(employee.getId()).orElse(null)  ;
em.setId(employee.getId());
        em.setName(employee.getName());
        em.setEmail(employee.getEmail());
        return repository.save(em);
    }
}
