package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
//    List<Employee> employees = new ArrayList<>();

    @GetMapping("/get-employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/get-employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok().body(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-employee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        String result = employeeService.addEmployee(employee);
        if (result.equals("Saved")) {
            return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"Employee Added\"}");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Failed to add employee\"}");
        }
    }


    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id)) {
            return ResponseEntity.ok("Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


@PutMapping("/update-employee/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        boolean updated = employeeService.updateEmployee(id, employee);
        if (updated) {
            return ResponseEntity.ok().body("{\"message\": \"Employee Updated\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Employee not found\"}");
        }
    }

}
