// LOGISTICA_AGROVISION/log-agrov-frontend/src/app/calendario/calendario.ts
import { Component, OnInit } from '@angular/core';
import { CalendarioService } from '../services/calendario.service';
import { ProgramacionCalendario } from '../models/programacion-calendario';

@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.html',
  styleUrls: ['./calendario.css']
})
export class CalendarioComponent implements OnInit {
  fechaSeleccionada: string = '';
  programacion: ProgramacionCalendario[] = [];
  mensajeError: string = '';

  constructor(private calendarioService: CalendarioService) { }

  ngOnInit(): void {
    this.fechaSeleccionada = this.getFechaActualFormato();
    this.buscarProgramacion();
  }

  getFechaActualFormato(): string {
    const today = new Date();
    const year = today.getFullYear();
    const month = String(today.getMonth() + 1).padStart(2, '0');
    const day = String(today.getDate()).padStart(2, '0');
    return `<span class="math-inline">\{year\}\-</span>{month}-${day}`;
  }

  buscarProgramacion(): void {
    if (!this.fechaSeleccionada) {
      this.mensajeError = 'Por favor, selecciona una fecha.';
      this.programacion = [];
      return;
    }
    this.mensajeError = '';

    this.calendarioService.getProgramacionAsignacion(this.fechaSeleccionada).subscribe({
      next: (data) => {
        if (data === null || data.length === 0) {
          this.programacion = [];
          this.mensajeError = 'No hay programación para la fecha seleccionada.';
        } else {
          this.programacion = data;
          console.log('Programación obtenida:', this.programacion);
        }
      },
      error: (error) => {
        console.error('Error al obtener la programación:', error);
        this.programacion = [];
        this.mensajeError = 'Error al cargar la programación. Verifica la consola del navegador para más detalles.';
        if (error.status === 0) {
          this.mensajeError += ' (Posiblemente el backend no está corriendo o CORS no está configurado correctamente).';
        } else if (error.status === 400) {
            this.mensajeError += ' (Error en la solicitud: verifica el formato de la fecha).';
        } else if (error.status === 404) {
            this.mensajeError += ' (Endpoint del backend no encontrado. Revisa la URL en calendario.service.ts).';
        }
      }
    });
  }
}
