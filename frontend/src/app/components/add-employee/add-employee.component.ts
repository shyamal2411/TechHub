import { EmployeeService } from './../../employee.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/employee';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit{

  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
  }
 

  OnSubmit() {
    this.employeeService.addEmployee(this.employee).subscribe(data => {
      console.log(data);
      this.router.navigate(['/employees']);
    });
  }

}
