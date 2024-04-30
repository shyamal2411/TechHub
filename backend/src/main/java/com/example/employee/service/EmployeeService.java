package com.example.employee.service;

import com.example.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    String addEmployee(Employee employee);

    boolean deleteEmployee(Long id);

    boolean updateEmployee(Long id, Employee employee);

//    Employee getEmployee();

    Employee getEmployeeById(Long id);
}
