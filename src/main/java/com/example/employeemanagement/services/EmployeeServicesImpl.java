package com.example.employeemanagement.services;

import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException
                        ("employee with the id "+ id +"does not exist"));
    }

    @Override
    public String updateEmployee(Long id, Employee employeeDetails) {
        Employee foundEmployee = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException
                ("employeeDetails with the id "+ id +"does not exist"));
        foundEmployee.setFirstName(employeeDetails.getFirstName() != null && !employeeDetails.getFirstName().equals("") ?
                employeeDetails.getFirstName() : foundEmployee.getFirstName());
        foundEmployee.setLastName(employeeDetails.getLastName() != null && !employeeDetails.getLastName().equals("") ?
                employeeDetails.getLastName() : foundEmployee.getLastName());
        foundEmployee.setEmail(employeeDetails.getEmail() != null && !employeeDetails.getEmail().equals("") ?
                employeeDetails.getEmail() : foundEmployee.getEmail());
        employeeRepository.save(foundEmployee);
        return "Employee with the id "+id+" updated successfully";
    }
}
