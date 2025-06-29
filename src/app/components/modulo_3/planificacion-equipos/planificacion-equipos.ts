import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Sidebar } from '../../sidebar/sidebar';
import { Area, Empleado, Equipo, ProgEquipoDto } from '../models/models'; // Asegúrate de que las rutas sean correctas
import { ProgEquiposService } from '../../../services/progEquiposService'; // Asegúrate de que la ruta sea correcta
import { HttpClientModule } from '@angular/common/http'; // Importa esto si tu componente es standalone

@Component({
  selector: 'app-planificacion-equipos',
  imports: [ FormsModule, CommonModule, HttpClientModule], // Agrega HttpClientModule si es standalone
  templateUrl: './planificacion-equipos.html',
  styleUrl: './planificacion-equipos.css',
  providers: [DatePipe]
})
export class PlanificacionEquipos implements OnInit {
  listadoEquipos: Equipo[] = [];
  listadoAreas: Area[] = [];
  listadoEmpleados: Empleado[] = [];

  mensajeExito: string | null = null;
  mensajeError: string | null = null;
  cargandoAsignacion: boolean = false; // Controla el estado del botón "Planificar"

  // Define el estado inicial (por defecto) del DTO para un reinicio limpio
  private readonly DEFAULT_DTO: ProgEquipoDto = {
    idEquipo: 0,
    fechaInicio: '',
    fechaFin: '',
    descripcionTarea: '',
    idArea: '',
    idEmpleadoRegistra: 1, // Mantener este valor fijo si es así
    idEmpleadoSolicita: 0
  };

  // Inicializa el DTO del formulario con los valores por defecto
  dto: ProgEquipoDto = { ...this.DEFAULT_DTO };

  constructor(private datePipe: DatePipe, private s: ProgEquiposService) { }

  ngOnInit(): void {
    // Carga inicial de datos de listas (ej. equipos, áreas, empleados)
    // Se incluye manejo de errores básico para depuración, pero no muestra mensaje en pantalla para esto
    this.s.getEquipos().subscribe({
      next: (res: any) => { this.listadoEquipos = res; },
      error: (err: any) => { console.error('Error al cargar equipos:', err); /* Opcional: this.mensajeError = 'Error al cargar equipos.'; */ }
    });
    this.s.getAreas().subscribe({
      next: (res: any) => { this.listadoAreas = res; },
      error: (err: any) => { console.error('Error al cargar áreas:', err); /* Opcional: this.mensajeError = 'Error al cargar áreas.'; */ }
    });
    this.s.getEmpleados().subscribe({
      next: (res: any) => { this.listadoEmpleados = res; },
      error: (err: any) => { console.error('Error al cargar empleados:', err); /* Opcional: this.mensajeError = 'Error al cargar empleados.'; */ }
    });
  }

  print(): void {
    console.log('DTO actual (antes de enviar):', this.dto);
  }

  registrarAsignacion(): void {
    // 1. Siempre limpia los mensajes y deshabilita el botón al iniciar un nuevo intento
    this.mensajeExito = null;
    this.mensajeError = null;
    this.cargandoAsignacion = true; // Deshabilita el botón de "Planificar"

    this.print(); // Muestra el DTO en consola para depuración

    // 2. Llama al servicio para registrar la asignación
    this.s.programarAsignacion(this.dto).subscribe({
      next: (response: any) => {
        // 3. SI LA RESPUESTA ES EXITOSA (código 200 OK)
        this.mensajeExito = response.message || '¡Asignación programada con éxito!';
        console.log('Mensaje de éxito asignado (en componente):', this.mensajeExito);
        console.log('Respuesta del servicio (Éxito):', response);

        // Reinicia el formulario SOLO si el registro fue exitoso
        this.dto = { ...this.DEFAULT_DTO };

        this.cargandoAsignacion = false; // Habilita el botón de "Planificar"
      },
      error: (error: any) => {
        // 4. SI LA RESPUESTA ES UN ERROR (código 4xx o 5xx)
        this.mensajeError = error.error?.message || 'Error al programar la asignación. Por favor, verifique los datos.';
        console.log('Mensaje de error asignado (en componente):', this.mensajeError);
        console.error('Error al programar asignación:', error);

        // El formulario NO SE REINICIA. Los datos ingresados por el usuario se mantienen.
        // El usuario puede ver qué datos estaban mal y corregirlos directamente.

        this.cargandoAsignacion = false; // Habilita el botón de "Planificar"
      }
    });
  }

  // Método auxiliar para formatear fechas si fuera necesario (mantengo el tuyo)
  private toISODateTime(dateTimeValue: string): string {
    return `${dateTimeValue}:00`;
  }
}
