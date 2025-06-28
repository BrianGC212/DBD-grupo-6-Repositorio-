import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Sidebar } from '../../sidebar/sidebar';
import { RouterModule } from '@angular/router';
import { ReporteIncidenteEntrega } from '../../models/models';
import { ReporteIncidenteService } from '../../../services/reporte-incidente-service';

@Component({
  selector: 'app-visualizar-reporte-incidente',
  imports: [CommonModule, RouterModule],
  templateUrl: './visualizar-reporte-incidente.html',
  styleUrl: './visualizar-reporte-incidente.css'
})
export class VisualizarReporteIncidente implements OnInit{
  reporteIncidenteEntregas: ReporteIncidenteEntrega[] = [];
  constructor(private incidenteService: ReporteIncidenteService) {}

  ngOnInit(): void {
    this.incidenteService.getListado().subscribe(data => {
      this.reporteIncidenteEntregas = data;
    });
  }
}
