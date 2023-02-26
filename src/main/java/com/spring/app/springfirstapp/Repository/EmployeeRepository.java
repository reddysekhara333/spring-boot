package com.spring.app.springfirstapp.Repository;

import com.spring.app.springfirstapp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findByName(String name);

}
