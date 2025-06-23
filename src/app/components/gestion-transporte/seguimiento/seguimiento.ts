import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Sidebar } from '../../sidebar/sidebar';
import { RouterModule } from '@angular/router';
import { SeguimientoService } from '../../../services/seguimiento-service';
import { SeguimientoI } from '../../models/models';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-seguimiento',
  imports: [CommonModule,Sidebar,RouterModule,FormsModule],
  templateUrl: './seguimiento.html',
  styleUrl: './seguimiento.css'
})
export class Seguimiento {
  seguimientos: SeguimientoI[] = [];
  codigoBusqueda: string = '';
  
  constructor(private seguimientoService: SeguimientoService) {}

  ngOnInit(): void {
    this.cargarSeguimiento();
  }
  cargarSeguimiento(): void {
    this.seguimientoService.getSeguimientos().subscribe((data) => {
      this.seguimientos = data;
    });
  }
  buscarPorCodigo(): void {
    if (this.codigoBusqueda.trim()) {
      const payload = { cod_orden_transporte: this.codigoBusqueda.trim() };
      this.seguimientoService.getSeguimientoPorOrden(payload).subscribe((data) => {
        this.seguimientos = data;
      });
    }
  }
}
