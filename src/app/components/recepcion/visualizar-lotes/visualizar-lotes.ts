import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Lote, LoteRecepcionVista } from '../../models/models';
import { LoteService } from '../../../services/recepcion/lote';
import { RecepcionService } from '../../../services/recepcion/recepcion'; 
import { NavigationEnd, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-visualizar-lotes',
  standalone: true,
  imports: [ CommonModule, FormsModule],
  templateUrl: './visualizar-lotes.html',
  styleUrl: './visualizar-lotes.css'
})
export class VisualizarLotes implements OnInit {

  lotes: Lote[] = [];
  mostrarFormulario = false;

  // Formulario de nuevo lote
  nuevoLote = {
    idTipoLote: null,
    cantidadTotal: null,
    unidad: '',
    fechaProduccion: '',
    fechaVencimiento: '',
    idProducto: ''
  };

  // Formulario de recepción
  loteSeleccionado: LoteRecepcionVista | null = null;

  datosRecepcion: {
    cantidadRecibida: number | null;
    observaciones: string;
  } = {
    cantidadRecibida: null,
    observaciones: ''
  };

  mostrarFormularioRecepcion = false;

  constructor(
  private router: Router,
  private loteService: LoteService,
  private recepcionService: RecepcionService,
  private http: HttpClient,
  private cdr: ChangeDetectorRef
  
) {
  this.router.events.pipe(
    filter(event => event instanceof NavigationEnd)
  ).subscribe(() => {
    this.cargarLotes();
  });
}


ngOnInit(): void {
  this.cargarLotes();
}


  cargarLotes(): void {
  this.loteService.obtenerLotes().subscribe({
    next: (data) => {
      this.lotes = data;
      this.cdr.detectChanges(); // <--- fuerza la actualización del DOM
    },
    error: (err) => console.error('Error al obtener los lotes', err)
  });
}


  registrarLote(): void {
    this.loteService.registrarLote(this.nuevoLote).subscribe({
      next: () => {
        alert('Lote registrado con éxito');
        this.mostrarFormulario = false;
        this.reiniciarFormulario();
        this.cargarLotes();
      },
      error: (err) => {
        if (err.status === 200) {
          alert('Lote registrado (rr.status === 200)');
          this.mostrarFormulario = false;
          this.reiniciarFormulario();
          this.cargarLotes();
        } else {
          alert('Error al registrar el lote');
          console.error('Error real al registrar lote', err);
        }
      }
    });
  }

  reiniciarFormulario(): void {
    this.nuevoLote = {
      idTipoLote: null,
      cantidadTotal: null,
      unidad: '',
      fechaProduccion: '',
      fechaVencimiento: '',
      idProducto: ''
    };
  }

  // === Funciones de recepción ===

  seleccionarLoteParaRecepcion(codLote: string): void {
    this.loteService.ObtenerDatosLote(codLote).subscribe({
      next: (data: LoteRecepcionVista) => {
        this.loteSeleccionado = data;
        this.mostrarFormularioRecepcion = true;
        this.datosRecepcion = { cantidadRecibida: null, observaciones: '' };
      },
      error: (err) => {
        console.error('Error al obtener datos del lote para recepción', err);
      }
    });
  }

  cancelarRecepcion(): void {
    this.loteSeleccionado = null;
    this.datosRecepcion = {
      cantidadRecibida: null,
      observaciones: ''
    };
    this.mostrarFormularioRecepcion = false;
  }

  enviarRecepcion(tipo: 'aprobado' | 'observado'): void {
    const payload = {
      codLote: this.loteSeleccionado?.cod_lote,
      cantidadRecibida: this.datosRecepcion.cantidadRecibida,
      observaciones: this.datosRecepcion.observaciones
    };

    const request$ = tipo === 'aprobado'
      ? this.recepcionService.aprobarRecepcion(payload)
      : this.recepcionService.observarRecepcion(payload);

    request$.subscribe({
      next: (mensaje: string) => {
        this.cancelarRecepcion();
        alert(mensaje);
        setTimeout(() => this.cargarLotes(), 100); // Refresca con pequeño delay
      },
      error: (error) => {
        console.error('Error al registrar recepción:', error);
        alert('Ocurrió un error al registrar la recepción');
      }
    });
  }
}
