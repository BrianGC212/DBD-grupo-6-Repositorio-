import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Sidebar } from '../../sidebar/sidebar';

@Component({
  selector: 'app-dashboard-recepcion',
  templateUrl: './dashboard-recepcion.html',
  styleUrl: './dashboard-recepcion.css',
  standalone: true,
  imports: [Sidebar]
})
export class DashboardRecepcion {

  constructor(private router: Router) {}

  irA(ruta: string) {
  if (ruta === 'registro-lotes') {
    this.router.navigate(['/visualizar-lotes']);
  } else if (ruta === 'control-calidad') {
    this.router.navigate(['/control-calidad']);
  } else if (ruta === 'generacion-reportes') {
    this.router.navigate(['/generacion-reportes']);
  } else {
    this.router.navigate([`/${ruta}`]);
  }
}
}
