package com.example.employeemanager.repository;

import com.example.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Optional<Employee> findEmployeeById(Long id);

    @Transactional
    void deleteEmployeeById(Long id);
}
