import { Component } from '@angular/core';
import { Sidebar } from '../../sidebar/sidebar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-preparacion-pedidos',
  imports: [Sidebar],
  templateUrl: './preparacion-pedidos.html',
  styleUrl: './preparacion-pedidos.css'
})
export class PreparacionPedidos {
  constructor(private router: Router) {

  }
  irA(ruta: string): void {
    this.router.navigate([ruta]);
  }

}
