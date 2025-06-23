import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Sidebar } from '../../sidebar/sidebar';
import { RouterModule } from '@angular/router';
import { GuiasRemisionService } from '../../../services/guias-remision-service';
import { GuiaRemisionInput } from '../../models/models';

@Component({
  selector: 'app-registrar-guia-remision',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, Sidebar, RouterModule],
  templateUrl: './registrar-guia-remision.html',
  styleUrls: ['./registrar-guia-remision.css']
})
export class RegistrarGuiaRemision {
  guiaForm: FormGroup;
  mensaje: string = '';

  constructor(private fb: FormBuilder, private guiaService: GuiasRemisionService) {
    this.guiaForm = this.fb.group({
      fecha_de_traslado: ['', Validators.required],
      placa_vehiculo: ['', Validators.required],
      cod_empleado: ['', Validators.required],
      cod_pedido: ['', Validators.required],
      cod_transportista: ['', Validators.required]
    });
  }

  registrarGuia(): void {
    if (this.guiaForm.valid) {
      const rawFecha = this.guiaForm.value.fecha_de_traslado;

      let fechaISO = rawFecha;
      if (rawFecha.includes('/')) {
        const partes = rawFecha.split('/');
        fechaISO = `${partes[2]}-${partes[1]}-${partes[0]}`;
      }

      const datos: GuiaRemisionInput = {
        ...this.guiaForm.value,
        fecha_de_traslado: fechaISO
      };

      this.guiaService.registrarGuia(datos).subscribe({
        next: () => {
          this.mensaje = 'Guía registrada correctamente ✅';
          this.guiaForm.reset();
        },
        error: () => {
          this.mensaje = 'Ocurrió un error al registrar la guía ❌';
        }
      });
    } else {
      this.mensaje = 'Por favor completa todos los campos 🛑';
    }
  }
}
