package com.example.employeemanagement.services;

import com.example.employeemanagement.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {
    List<Employee> getAllEmployee();
    Employee createEmployee(Employee employee);
    Employee getEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
    Map<String, Boolean> deleteEmployee(Long id);
}
