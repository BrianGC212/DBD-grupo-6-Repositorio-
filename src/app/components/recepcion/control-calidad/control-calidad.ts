import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { RecepcionService } from '../../../services/recepcion/recepcion';
import { Router, NavigationEnd, RouterModule } from '@angular/router';
import { filter } from 'rxjs/operators';
import { FormsModule } from '@angular/forms';
import { RecepcionConId } from '../../models/models';

@Component({
  selector: 'app-control-calidad',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './control-calidad.html',
  styleUrls: ['./control-calidad.css']
})
export class ControlCalidad implements OnInit {
  recepciones: RecepcionConId[] = [];
  cargando: boolean = true;
  idEmpleado: number = 0;

  formularioVisible: boolean = false;
  modo: 'aprobar' | 'observar' = 'aprobar';
  recepcionSeleccionada: RecepcionConId | null = null;
  temperatura: number = 0;
  observacionesLote: string = '';
  observacionesEmpaque: string = '';

  constructor(
    private recepcionService: RecepcionService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
      this.cargarDatos();
    });
  }

  ngOnInit(): void {
    this.cargarDatos();
  }

  cargarDatos() {
    this.cargando = true;
    this.recepcionService.visualizarRecepciones().subscribe({
      next: data => {
        this.recepciones = data.map((r: any) => ({
          id_recepcion: r.id_recepcion,
          cod_recepcion: r.cod_recepcion,
          nombre_producto: r.nombre_producto,
          descripcion_lote: r.descripcion_lote,
          cantidad: r.cantidad,
          unidad: r.unidad,
          estado_recepcion: r.estado_recepcion
        }));
        this.cargando = false;
        this.cdr.detectChanges();
      },
      error: err => {
        console.error('Error cargando recepciones:', err);
        this.cargando = false;
        this.cdr.detectChanges();
      }
    });
  }

  abrirFormulario(codRecepcion: string, modo: 'aprobar' | 'observar') {
    this.modo = modo;
    this.recepcionService.obtenerRecepcionConId(codRecepcion).subscribe({
      next: (data) => {
        if (!data.id_recepcion || data.id_recepcion === 0) {
          console.error('ID de recepción inválido:', data);
        } else {
          console.log('Recepción cargada:', data); // 👈 Revisión útil
        }
        this.recepcionSeleccionada = data;
        this.formularioVisible = true;
        this.temperatura = 0;
        this.observacionesLote = '';
        this.observacionesEmpaque = '';
      },
      error: err => console.error('Error al obtener recepción:', err)
    });
  }

  cerrarFormulario() {
    this.formularioVisible = false;
    this.recepcionSeleccionada = null;
    this.temperatura = 0;
    this.observacionesLote = '';
    this.observacionesEmpaque = '';
  }

  enviarFormulario() {
    if (!this.recepcionSeleccionada) return;

    const idRecepcion = this.recepcionSeleccionada.id_recepcion;
    if (!idRecepcion || idRecepcion === 0) {
      console.error('ID de recepción inválido al enviar formulario:', this.recepcionSeleccionada);
      return;
    }

    const baseData: any = {
      idEstadoPaqueteRecepcion: this.modo === 'aprobar' ? 'OKPR' : 'OBS',
      temperaturaProducto: this.temperatura,
      idRecepcion: idRecepcion,
      idEmpleado: this.idEmpleado
    };

    if (this.modo === 'observar') {
      if (this.observacionesLote.trim()) {
        baseData.observacionesLote = this.observacionesLote.trim();
      }
      if (this.observacionesEmpaque.trim()) {
        baseData.observacionesEmpaque = this.observacionesEmpaque.trim();
      }
    }

    const obs = this.modo === 'aprobar'
      ? this.recepcionService.aprobarControlCalidad(baseData)
      : this.recepcionService.observarControlCalidad(baseData);

    obs.subscribe({
      next: () => {
        this.cerrarFormulario();
        this.cargarDatos();
      },
      error: err => {
        console.error('Error al enviar:', err);
      }
    });
  }
}
