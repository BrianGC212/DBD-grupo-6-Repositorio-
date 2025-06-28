import { Component, OnInit } from '@angular/core';
import { OrdenTransporte, SeguimientoI } from '../../models/models';
import { OrdenesTransporteService } from '../../../services/ordenes-transporte-service';
import { RouterModule } from '@angular/router';
import { Sidebar } from '../../sidebar/sidebar';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-visualizar-ordenes-transporte',
  standalone: true,
  imports: [RouterModule,CommonModule],
  templateUrl: './visualizar-ordenes-transporte.html',
  styleUrl: './visualizar-ordenes-transporte.css'
})
export class VisualizarOrdenesTransporte implements OnInit{
  ordenes: OrdenTransporte[] = [];
  showSeguimientoModal: boolean = false;
  mostrarModalGuias: boolean = false;

  ordenActual: string = '';
  seguimientoDetalle: SeguimientoI[] = [];
  guiasDeOrden: any[] = [];

  constructor(
    private ordenService: OrdenesTransporteService,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.ordenService.getListado().subscribe(data => {
      this.ordenes = data;
    });
  }

  verSeguimiento(codigo: string): void {
    this.ordenActual = codigo;
    this.http.post<SeguimientoI[]>('http://localhost:8080/transporte/seguimientoPorOrden', {
      cod_orden_transporte: codigo
    }).subscribe({
      next: (data) => {
        this.seguimientoDetalle = data;
        this.showSeguimientoModal = true;
      },
      error: (err) => {
        console.error('Error obteniendo seguimiento:', err);
        this.seguimientoDetalle = [];
        this.showSeguimientoModal = false;
      }
    });
  }

  cerrarSeguimientoModal(): void {
    this.showSeguimientoModal = false;
    this.seguimientoDetalle = [];
  }

  verGuiasOrden(codigo: string): void {
    this.ordenActual = codigo;
    const payload = { cod_orden_transporte: codigo };

    this.ordenService.obtenerGuiasPorOrden(payload).subscribe({
      next: (data) => {
        this.guiasDeOrden = data;
        this.mostrarModalGuias = true;
      },
      error: () => {
        alert('Error al obtener las guías de esta orden ❌');
      }
    });
  }

  cerrarModalGuias(): void {
    this.mostrarModalGuias = false;
    this.guiasDeOrden = [];
  }
}