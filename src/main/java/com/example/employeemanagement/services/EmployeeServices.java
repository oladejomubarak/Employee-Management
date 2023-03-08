package com.example.employeemanagement.services;

import com.example.employeemanagement.model.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> getAllEmployee();
    Employee createEmployee(Employee employee);
    Employee getEmployee(Long id);
}
