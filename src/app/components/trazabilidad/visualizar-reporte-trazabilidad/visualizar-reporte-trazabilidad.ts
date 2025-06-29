import { Component, OnInit, NgZone, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { Sidebar } from '../../sidebar/sidebar';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-visualizar-reporte-trazabilidad',
  standalone: true,
  imports: [Sidebar, CommonModule, RouterModule, HttpClientModule, FormsModule],
  templateUrl: './visualizar-reporte-trazabilidad.html',
  styleUrls: ['./visualizar-reporte-trazabilidad.css']
})
export class VisualizarReporteTrazabilidad implements OnInit {
  reportes: any[] = [];
  reportesOriginales: any[] = [];
  mostrarDetalle: boolean = false;
  detalleSeleccionado: any = null;
  searchTerm: string = '';
  isLoading: boolean = true;

  constructor(
    private http: HttpClient,
    private ngZone: NgZone,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.cargarReportes();
  }

  cargarReportes(): void {
    this.isLoading = true;
    this.http.get<any[]>('http://localhost:8080/trazabilidad/reporteTrazabilidad')
      .subscribe({
        next: (data) => {
          this.ngZone.run(() => {
            this.reportes = data;
            this.reportesOriginales = [...data];
            this.isLoading = false;
            this.cdr.markForCheck();
          });
        },
        error: (error) => {
          this.ngZone.run(() => {
            console.error('Error al cargar los reportes de trazabilidad', error);
            this.isLoading = false;
            this.cdr.markForCheck();
          });
        }
      });
  }

  filtrarReportes(): void {
    if (!this.searchTerm) {
      this.reportes = [...this.reportesOriginales];
      return;
    }

    const term = this.searchTerm.toLowerCase();
    this.reportes = this.reportesOriginales.filter(reporte => 
      reporte.codigo.toLowerCase().includes(term) ||
      reporte.proceso.toLowerCase().includes(term) ||
      (reporte.estado && reporte.estado.toLowerCase().includes(term))
    );
  }

  verDetalle(reporte: any): void {
    const codigo = reporte.codigo;
    this.http.get<any>(`http://localhost:8080/trazabilidad/reporteDetalleTrazabilidad/${codigo}`)
      .subscribe({
        next: (detalle) => {
          this.ngZone.run(() => {
            this.detalleSeleccionado = detalle;
            this.mostrarDetalle = true;
            this.cdr.markForCheck();
          });
        },
        error: (error) => {
          this.ngZone.run(() => {
            console.error('Error al cargar detalle del reporte', error);
            this.cdr.markForCheck();
          });
        }
      });
  }

  cerrarDetalle(): void {
    this.mostrarDetalle = false;
    this.detalleSeleccionado = null;
  }

  descargarAnexoSimulado(nombreArchivo: string): void {
    const extension = nombreArchivo.split('.').pop()?.toLowerCase() || 'txt';
    let mimeType = 'text/plain';
    let contenido = 'Este es un archivo simulado';

    switch (extension) {
      case 'pdf':
        mimeType = 'application/pdf';
        contenido = '%PDF-1.4\n% Simulación PDF';
        break;
      case 'mp3':
        mimeType = 'audio/mpeg';
        contenido = 'ID3 Simulación de MP3';
        break;
      case 'mp4':
        mimeType = 'video/mp4';
        contenido = '....simulacion video....';
        break;
      case 'xlsx':
        mimeType = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
        contenido = 'Simulación de archivo Excel';
        break;
      case 'txt':
      default:
        mimeType = 'text/plain';
        contenido = 'Contenido simulado';
        break;
    }

    const blob = new Blob([contenido], { type: mimeType });
    const url = window.URL.createObjectURL(blob);

    const a = document.createElement('a');
    a.href = url;
    a.download = nombreArchivo;
    a.click();
    window.URL.revokeObjectURL(url);
  }
}
