import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
import { UpdateEmployeeComponent } from './components/update-employee/update-employee.component';
import { DeleteEmployeeComponent } from './components/delete-employee/delete-employee.component';
import { EmployeeDetailsComponent } from './components/employee-details/employee-details.component';

const routes: Routes = [
  {
    path: 'employees',
    component: EmployeeListComponent
  },
  {
    path: '',
    redirectTo: 'employees',
    pathMatch: 'full',
  },
  {
    path: 'add-employee',
    component: AddEmployeeComponent,
  },
  {
    path: 'update-employee/:id',
    component: UpdateEmployeeComponent,
  },
  {
    path: 'delete-employee/:id',
    component: DeleteEmployeeComponent
  },
  {
    path: 'employee-details/:id',
    component: EmployeeDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
