package com.example.employeemanagement.controller;

import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){

        return employeeServices.getAllEmployee();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee ){
        return employeeServices.createEmployee(employee);
    }
    @GetMapping("/employess/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
       Employee foundEmployee = employeeServices.getEmployee(id);
        return ResponseEntity.ok(foundEmployee);
    }
}
