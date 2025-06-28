import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Sidebar } from '../../sidebar/sidebar';

@Component({
  selector: 'app-dashboard-recepcion',
  templateUrl: './dashboard-recepcion.html',
  styleUrl: './dashboard-recepcion.css',
  standalone: true,
  imports: []
})
export class DashboardRecepcion {

  constructor(private router: Router) {}

  irA(ruta: string) {
  this.router.navigate([`/${ruta}`]);
}

}