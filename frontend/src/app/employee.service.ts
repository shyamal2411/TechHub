import { HttpClient } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private getEmployees = "http://localhost:8080/api/employee/get-employees"

  constructor(private httpClient: HttpClient) { }

  getEmployeesList(): Observable<Employee[]>{
    console.log("getEmployeesList", this.getEmployees);
    
    return this.httpClient.get<Employee[]>(`${this.getEmployees}`);
  }

  addEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post("http://localhost:8080/api/employee/add-employee", employee);
  }


  getEmployeeById(id: number): Observable<Employee> { 
    return this.httpClient.get<Employee>(`http://localhost:8080/api/employee/get-employee/${id}`);
  
  }

  updateEmployee(id: number, employee: Employee): Observable<Object> {
    // console.log("updateEmployee", employee);
    return this.httpClient.put(`http://localhost:8080/api/employee/update-employee/${id}`, employee);
  }
  
  deleteEmployee(id: number): Observable<Object> { 
    return this.httpClient.delete(`http://localhost:8080/api/employee/delete-employee/${id}`);
  }

}
