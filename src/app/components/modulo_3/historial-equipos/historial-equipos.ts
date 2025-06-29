import { Component } from '@angular/core';
import { Sidebar } from '../../sidebar/sidebar';
import { CommonModule } from '@angular/common';
import { HistorialEquiposService } from '../../../services/historial-equipos';

@Component({
  selector: 'app-historial-equipos',
  imports: [CommonModule],
  templateUrl: './historial-equipos.html',
  styleUrl: './historial-equipos.css'
})
export class HistorialEquipos {
  reportes:any[]=[];

  constructor(private s:HistorialEquiposService) {
    this.loadHistoriales();
  }

  loadHistoriales(): void {
    this.s.getHistorialEquipos().subscribe({
      next: (data:any[]) => {
        this.reportes = data;
        console.log('Historial de equipos cargado:', this.reportes);
      }
    });
  }
}
