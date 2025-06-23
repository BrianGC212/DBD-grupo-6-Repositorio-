import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Sidebar } from '../../sidebar/sidebar';
import { RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { SeguimientoService } from '../../../services/seguimiento-service';
import { SeguimientoInput } from '../../models/models';

@Component({
  selector: 'app-registrar-seguimiento',
  standalone: true,
  imports: [CommonModule, Sidebar, RouterModule, ReactiveFormsModule],
  templateUrl: './registrar-seguimiento.html',
  styleUrl: './registrar-seguimiento.css'
})
export class RegistrarSeguimiento {
  seguimientoForm: FormGroup;
  mensaje: string = '';

  constructor(private fb: FormBuilder, private seguimientoService: SeguimientoService) {
    this.seguimientoForm = this.fb.group({
      descripcion: ['', Validators.required],
      id_estado_seguimiento: ['', Validators.required],
      cod_orden_transporte: ['', Validators.required]
    });
  }

  registrarSeguimiento(): void {
    if (this.seguimientoForm.valid) {
      const datos: SeguimientoInput = this.seguimientoForm.value;
      this.seguimientoService.registrarSeguimiento(datos).subscribe({
        next: () => {
          this.mensaje = 'Seguimiento registrado correctamente ✅';
          this.seguimientoForm.reset();
        },
        error: () => {
          this.mensaje = 'Error al registrar el seguimiento ❌';
        }
      });
    } else {
      this.mensaje = 'Por favor completa todos los campos 🛑';
    }
  }
}
