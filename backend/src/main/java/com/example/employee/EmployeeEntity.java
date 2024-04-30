package com.example.employee;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="emp_db")

public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private String position;

}
