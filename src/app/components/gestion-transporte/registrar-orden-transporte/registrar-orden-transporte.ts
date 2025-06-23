import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { Sidebar } from '../../sidebar/sidebar';
import { RouterModule } from '@angular/router';
import { OrdenTransporteInput } from '../../models/models';
import { OrdenesTransporteService } from '../../../services/ordenes-transporte-service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-registrar-orden-transporte',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, Sidebar, RouterModule],
  templateUrl: './registrar-orden-transporte.html',
  styleUrl: './registrar-orden-transporte.css'
})
export class RegistrarOrdenTransporte {
  ordenForm: FormGroup;
  mensaje: string = '';

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.ordenForm = this.fb.group({
      fecha_salida: ['', Validators.required],
      hora_salida: ['', Validators.required],
      cod_empleado: ['', Validators.required],
      guiasRemision: this.fb.array([
        this.fb.control('', Validators.required)
      ])
    });
  }

  get guiasRemision(): FormArray {
    return this.ordenForm.get('guiasRemision') as FormArray;
  }

  agregarGuia(): void {
    this.guiasRemision.push(this.fb.control('', Validators.required));
  }

  eliminarGuia(index: number): void {
    if (this.guiasRemision.length > 1) {
      this.guiasRemision.removeAt(index);
    }
  }

  registrar(): void {
    if (this.ordenForm.valid) {
      const datos = this.ordenForm.value;
      this.http.post('http://localhost:8080/transporte/registrarOrdenTransporte', datos).subscribe({
        next: () => {
          this.mensaje = 'Orden registrada correctamente ✅';
          this.ordenForm.reset();
          while (this.guiasRemision.length > 1) {
            this.guiasRemision.removeAt(0);
          }
          this.guiasRemision.at(0).setValue('');
        },
        error: () => {
          this.mensaje = 'Error al registrar la orden ❌';
        }
      });
    } else {
      this.mensaje = 'Por favor completa todos los campos 🛑';
    }
  }
}
