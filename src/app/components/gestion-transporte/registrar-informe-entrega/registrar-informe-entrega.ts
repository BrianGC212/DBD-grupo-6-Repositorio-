import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Sidebar } from '../../sidebar/sidebar';
import { RouterModule } from '@angular/router';
import { InformeEtregaInput } from '../../models/models';
import { InformeEntregaService } from '../../../services/informe-entrega-service';

@Component({
  selector: 'app-registrar-informe-entrega',
  imports: [CommonModule, ReactiveFormsModule, Sidebar, RouterModule],
  templateUrl: './registrar-informe-entrega.html',
  styleUrl: './registrar-informe-entrega.css'
})
export class RegistrarInformeEntrega {
  informeForm: FormGroup;
  mensaje: string = '';

  constructor(private fb: FormBuilder, private informeService: InformeEntregaService) {
    this.informeForm = this.fb.group({
      nombre_receptor: ['', Validators.required],
      dni_receptor: ['', [Validators.required, Validators.pattern(/^\d{8}$/)]],
      observacion: ['', Validators.required],
      cod_guia_remision: ['', Validators.required]
    });
  }

  registrarInforme(): void {
    if (this.informeForm.valid) {
      const datos: InformeEtregaInput = this.informeForm.value;
      this.informeService.registrarInforme(datos).subscribe({
        next: () => {
          this.mensaje = 'Informe registrado correctamente ✅';
          this.informeForm.reset();
        },
        error: () => {
          this.mensaje = 'Ocurrió un error al registrar el informe ❌';
        }
      });
    } else {
      this.mensaje = 'Por favor completa todos los campos 🛑';
    }
  }
}
