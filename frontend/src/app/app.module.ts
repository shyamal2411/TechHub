import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { HttpClientModule } from '@angular/common/http';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { UpdateEmployeeComponent } from './components/update-employee/update-employee.component';
import { DeleteEmployeeComponent } from './components/delete-employee/delete-employee.component';
import { EmployeeDetailsComponent } from './components/employee-details/employee-details.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    AddEmployeeComponent,
    NavbarComponent,
    UpdateEmployeeComponent,
    DeleteEmployeeComponent,
    EmployeeDetailsComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
