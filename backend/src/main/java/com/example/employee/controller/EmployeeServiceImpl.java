package com.example.employee.controller;

import com.example.employee.EmployeeEntity;
import com.example.employee.EmployeeRepository;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
//    List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeesList) {
            Employee emp = new Employee();

            emp.setId(employeeEntity.getId());
            emp.setFirstName(employeeEntity.getFirstName());
            emp.setLastName(employeeEntity.getLastName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setDepartment(employeeEntity.getDepartment());
            emp.setPosition(employeeEntity.getPosition());

            employees.add(emp);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(Long id){
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public String addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
//        employees.add(employee);
        employeeRepository.save(employeeEntity);
        return "Saved";
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public boolean updateEmployee(Long id, Employee employee){
        EmployeeEntity emp = employeeRepository.findById(id).get();
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmail(employee.getEmail());
        emp.setDepartment(employee.getDepartment());
        emp.setPosition(employee.getPosition());
        emp.setPassword(employee.getPassword());
        employeeRepository.save(emp);
        return true;
    }
}
