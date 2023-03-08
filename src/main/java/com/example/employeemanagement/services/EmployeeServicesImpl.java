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
    public String updateEmployee(Long id, Employee employee) {
        Employee foundEmployee = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException
                ("employee with the id "+ id +"does not exist"));
        foundEmployee.setFirstName(employee.getFirstName() != null && !employee.getFirstName().equals("") ?
                employee.getFirstName() : foundEmployee.getFirstName());
        foundEmployee.setLastName(employee.getLastName() != null && !employee.getLastName().equals("") ?
                employee.getLastName() : foundEmployee.getLastName());
        foundEmployee.setEmail(employee.getEmail() != null && !employee.getEmail().equals("") ?
                employee.getEmail() : foundEmployee.getEmail());
        employeeRepository.save(foundEmployee);
        return "Employee with the id "+id+" updated successfully";
    }
}
