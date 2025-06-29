import { Component, OnInit, ChangeDetectorRef, NgZone } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Sidebar } from '../../sidebar/sidebar';
import { jsPDF } from 'jspdf';
import autoTable from 'jspdf-autotable';

@Component({
  selector: 'app-visualizar-incidencias',
  standalone: true,
  imports: [Sidebar, CommonModule, RouterModule, HttpClientModule, FormsModule],
  templateUrl: './visualizar-incidencias.html',
  styleUrls: ['./visualizar-incidencias.css']
})
export class VisualizarIncidencias implements OnInit {
  incidencias: any[] = [];
  incidenciasOriginales: any[] = [];
  mostrarDetalle: boolean = false;
  mostrarFormularioRegistro: boolean = false;
  detalleSeleccionado: any = null;
  searchTerm: string = '';
  isLoading: boolean = true;

  nuevoRegistro: any = {
    codIncidencias: '',
    causa: '',
    tipoIncidencia: '',
    estado: '',
    fechaRegistrada: '',
    hora: '',
    observaciones: '',
    evidencias: '',
    fechaResolucion: '',
    idEmpleado: null,
    idProcesos: null
  };

  constructor(
    private http: HttpClient,
    private cdr: ChangeDetectorRef,
    private ngZone: NgZone
  ) {}

  ngOnInit(): void {
    this.cargarIncidencias();
  }

  cargarIncidencias(): void {
    this.isLoading = true;
    this.http.get<any[]>('http://localhost:8080/trazabilidad/visualizarIncidencias')
      .subscribe({
        next: (data) => {
          this.ngZone.run(() => {
            this.incidencias = data;
            this.incidenciasOriginales = [...data];
            this.isLoading = false;
            this.cdr.markForCheck();
          });
        },
        error: (error) => {
          this.ngZone.run(() => {
            console.error('Error al cargar incidencias', error);
            this.isLoading = false;
            this.cdr.markForCheck();
          });
        }
      });
  }

  filtrarIncidencias(): void {
    if (!this.searchTerm) {
      this.incidencias = [...this.incidenciasOriginales];
      return;
    }

    const term = this.searchTerm.toLowerCase();
    this.incidencias = this.incidenciasOriginales.filter(incidencia => 
      (incidencia.cod && incidencia.cod.toLowerCase().includes(term)) ||
      (incidencia.proceso && incidencia.proceso.toLowerCase().includes(term)) ||
      (incidencia.estado && incidencia.estado.toLowerCase().includes(term))
    );
  }

  verDetalle(incidencia: any): void {
    const cod = incidencia.cod;
    this.http.get<any>(`http://localhost:8080/trazabilidad/detalleIncidencia/${cod}`)
      .subscribe(detalle => {
        this.ngZone.run(() => {
          this.detalleSeleccionado = detalle;
          this.mostrarDetalle = true;
          this.cdr.markForCheck();
        });
      });
  }

  cerrarDetalle(): void {
    this.detalleSeleccionado = null;
    this.mostrarDetalle = false;
  }

  abrirFormularioRegistro(): void {
    this.mostrarFormularioRegistro = true;
  }

  cerrarFormularioRegistro(): void {
    this.mostrarFormularioRegistro = false;
    this.nuevoRegistro = {
      codIncidencias: '',
      causa: '',
      tipoIncidencia: '',
      estado: '',
      fechaRegistrada: '',
      hora: '',
      observaciones: '',
      evidencias: '',
      fechaResolucion: '',
      idEmpleado: null,
      idProcesos: null
    };
  }

  registrarIncidencia(): void {
    const datosEnvio = {
      causa: this.nuevoRegistro.causa,
      tipoIncidencia: this.nuevoRegistro.tipoIncidencia,
      estado: this.nuevoRegistro.estado,
      observaciones: this.nuevoRegistro.observaciones,
      evidencias: this.nuevoRegistro.evidencias,
      fechaResolucion: this.nuevoRegistro.fechaResolucion
    };

    const url = 'http://localhost:8080/trazabilidad/registrarIncidencia';
    this.http.post<boolean>(url, datosEnvio).subscribe({
      next: (exito) => {
        this.ngZone.run(() => {
          if (exito) {
            alert('Incidencia registrada correctamente');
            this.cargarIncidencias();
            this.cerrarFormularioRegistro();
          } else {
            alert('Error al registrar incidencia');
          }
        });
      },
      error: (error) => {
        this.ngZone.run(() => {
          console.error('Error al registrar incidencia', error);
          alert('Ocurrió un error al registrar');
        });
      }
    });
  }

  descargarIncidencia(): void {
    const incidencia = this.detalleSeleccionado;
    if (!incidencia) {
      console.error('No hay incidencia seleccionada para descargar');
      return;
    }

    const doc = new jsPDF();
    doc.setFontSize(16);
    doc.text('Reporte de Incidencia', 105, 15, { align: 'center' });

    const data = [
      ['Código', incidencia.cod || 'N/A'],
      ['Proceso', incidencia.proceso || 'N/A'],
      ['Causa', incidencia.causa || 'N/A'],
      ['Tipo de Incidencia', incidencia.tipoIncidencia || 'N/A'],
      ['Estado', incidencia.estado || 'N/A'],
      ['Fecha Registrada', incidencia.fechaActualizada ? new Date(incidencia.fechaActualizada).toLocaleDateString() : 'N/A'],
      ['Hora', incidencia.horaActualizada || 'N/A'],
      ['Observaciones', incidencia.observaciones || 'N/A'],
      ['Evidencias', incidencia.evidencias || 'N/A'],
      ['Fecha Resolución', incidencia.fechaResolucion ? new Date(incidencia.fechaResolucion).toLocaleDateString() : 'N/A']
    ];

    autoTable(doc, {
      startY: 25,
      head: [['Campo', 'Valor']],
      body: data,
      styles: {
        cellPadding: 5,
        fontSize: 10,
        valign: 'middle'
      },
      columnStyles: {
        0: { fontStyle: 'bold', cellWidth: 60 },
        1: { cellWidth: 120 }
      },
      margin: { left: 15, right: 15 }
    });

    const pageCount = doc.getNumberOfPages();
    for (let i = 1; i <= pageCount; i++) {
      doc.setPage(i);
      doc.setFontSize(10);
      doc.text(`Página ${i} de ${pageCount}`, 105, doc.internal.pageSize.height - 10, { align: 'center' });
      doc.text(new Date().toLocaleDateString(), 195, doc.internal.pageSize.height - 10, { align: 'right' });
    }

    doc.save(`incidencia_${incidencia.cod || 'reporte'}.pdf`);
  }

  descargarEvidencia(): void {
    const evidenciaNombre = this.detalleSeleccionado?.evidencias;

    if (!evidenciaNombre) {
      alert("No hay evidencia disponible.");
      return;
    }

    const extension = evidenciaNombre.split('.').pop()?.toLowerCase();
    const mimeTypes: { [key: string]: string } = {
      'pdf': 'application/pdf',
      'txt': 'text/plain',
      'jpg': 'image/jpeg',
      'jpeg': 'image/jpeg',
      'png': 'image/png',
      'mp3': 'audio/mpeg',
      'mp4': 'video/mp4'
    };

    const mimeType = mimeTypes[extension || ''] || 'application/octet-stream';

    let contenido: BlobPart;
    switch (extension) {
      case 'txt':
        contenido = 'Contenido ficticio generado.\nEjemplo de archivo .txt';
        break;
      case 'pdf':
        contenido = '%PDF-1.4\n% Simulación PDF';
        break;
      case 'mp3':
        contenido = new Uint8Array([0x49, 0x44, 0x33]);
        break;
      case 'jpg':
        contenido = new Uint8Array([0xFF, 0xD8, 0xFF]);
        break;
      case 'png':
        contenido = new Uint8Array([0x89, 0x50, 0x4E, 0x47]);
        break;
      default:
        contenido = 'Archivo generado como evidencia ficticia.';
    }

    const blob = new Blob([contenido], { type: mimeType });
    const url = window.URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = evidenciaNombre;
    a.click();
    window.URL.revokeObjectURL(url);
  }
}