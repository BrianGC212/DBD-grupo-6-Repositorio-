import { Component, OnInit, NgZone, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { Sidebar } from '../../sidebar/sidebar';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-visualizar-proceso',
  standalone: true,
  imports: [ CommonModule, RouterModule, HttpClientModule, FormsModule],
  templateUrl: './visualizar-proceso.html',
  styleUrls: ['./visualizar-proceso.css']
})
export class VisualizarProceso implements OnInit {
  procesos: any[] = [];
  procesosOriginales: any[] = [];
  mostrarDetalle: boolean = false;
  detalleProceso: any = null;
  searchTerm: string = '';
  isLoading: boolean = true; // Nuevo: Control de estado de carga

  constructor(
    private http: HttpClient,
    private ngZone: NgZone, // Inyectar NgZone
    private cdr: ChangeDetectorRef // Inyectar ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.cargarProcesos();
  }

  cargarProcesos(): void {
    this.isLoading = true;
    this.http.get<any[]>('http://localhost:8080/trazabilidad/visualizarProcesos')
      .subscribe({
        next: (data) => {
          this.ngZone.run(() => {
            this.procesos = data;
            this.procesosOriginales = [...data];
            this.isLoading = false;
            this.cdr.markForCheck();
          });
        },
        error: (error) => {
          this.ngZone.run(() => {
            console.error('Error al cargar los procesos', error);
            this.isLoading = false;
            this.cdr.markForCheck();
          });
        }
      });
  }

  filtrarProcesos(): void {
    if (!this.searchTerm) {
      this.procesos = [...this.procesosOriginales];
      return;
    }

    const term = this.searchTerm.toLowerCase();
    this.procesos = this.procesosOriginales.filter(proceso => 
      proceso.codigo.toLowerCase().includes(term) ||
      proceso.proceso.toLowerCase().includes(term) ||
      (proceso.estado && proceso.estado.toLowerCase().includes(term))
    );
  }

  verDetalleProceso(codigo: string): void {
    this.http.get<any[]>(`http://localhost:8080/trazabilidad/detalleProceso/${codigo}`)
      .subscribe({
        next: (data) => {
          this.ngZone.run(() => {
            console.log('Datos recibidos:', data);
            if (data && data.length > 0) {
              this.detalleProceso = data[0];
              this.mostrarDetalle = true;
            } else {
              console.warn('No se encontraron datos para el código:', codigo);
            }
            this.cdr.markForCheck();
          });
        },
        error: (error) => {
          this.ngZone.run(() => {
            console.error('Error al obtener detalle del proceso', error);
            this.cdr.markForCheck();
          });
        }
      });
  }

  cerrarDetalle(): void {
    this.mostrarDetalle = false;
    this.detalleProceso = null;
    this.cdr.markForCheck(); // Asegurar actualización de la vista
  }
}