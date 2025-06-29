import { Component } from '@angular/core';
import { Sidebar } from '../../sidebar/sidebar';
import { Programacion } from '../models/models';
import { ProgEquiposService } from '../../../services/progEquiposService';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-visualizar-programaciones',
  imports: [Sidebar,CommonModule,FormsModule],
  templateUrl: './visualizar-programaciones.html',
  styleUrl: './visualizar-programaciones.css'
})
export class VisualizarProgramaciones {
  programaciones:Programacion[] = [];

  constructor(private s:ProgEquiposService) {
  }

  ngOnInit(): void {
    this.loadProgramaciones();
  }

  loadProgramaciones(): void {
    this.s.obtenerProgramaciones().subscribe({
      next: (res: Programacion[]) => {
        this.programaciones = res;
        console.log(this.programaciones);
      }
    });
  }

  borrarProgramacion(codigo: string): void {
    this.s.borrarProgramacion(codigo);
    this.loadProgramaciones(); // Recargar la lista después de borrar
  }
}
