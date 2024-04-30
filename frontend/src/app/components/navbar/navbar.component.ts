import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  links = [
    { name: 'HOME', link: '/employees' },
    { name: 'ADD EMPLOYEE', link: '/add-employee' },
    { name: 'EMPLOYEE LIST', link: '/' },
    { name: 'CONTACT', link: '/' }
  ];
  open = false;

  toggleMenu() {
    this.open = !this.open;
  }
}
