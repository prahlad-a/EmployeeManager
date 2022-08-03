package com.example.employeemanager.service;

import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepo employeeRepo;


    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeecode(UUID.randomUUID().toString());
        System.out.println("Added");
        return employeeRepo.save(employee);
    }

    public List<Employee> findAll(Employee employee)
    {
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long Id)
    {
        System.out.println("Found by id");
        return employeeRepo.findEmployeeById(Id).orElseThrow(()->new UserNotFoundException("Employee with id : "+Id+"was not found"));
    }

    public Employee updateEmployee(Employee employee)
    {
        System.out.println("Employee code " + employee.getEmployeecode());
        return employeeRepo.save(employee);
    }

    public void deleteEmployeeById(Long Id)
    {
        System.out.println("Deleted");
        employeeRepo.deleteEmployeeById(Id);

    }




}
