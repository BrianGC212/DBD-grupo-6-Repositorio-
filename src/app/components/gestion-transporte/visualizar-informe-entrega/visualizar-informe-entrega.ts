import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Sidebar } from '../../sidebar/sidebar';
import { InformeEntrega } from '../../models/models';
import { InformeEntregaService } from '../../../services/informe-entrega-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-visualizar-informe-entrega',
  imports: [CommonModule,RouterModule,Sidebar,FormsModule],
  templateUrl: './visualizar-informe-entrega.html',
  styleUrl: './visualizar-informe-entrega.css'
})
export class VisualizarInformeEntrega {
  informes: InformeEntrega[] = [];

  constructor(private informeService: InformeEntregaService) {}

  ngOnInit(): void {
    this.informeService.getInformes().subscribe(data => {
      this.informes = data;
    });
  }
  codigoBusqueda: string = '';

  cargarInformes(): void {
    this.informeService.getInformes().subscribe(data => {
      this.informes = data;
    });
  }

  buscarPorCodigo(): void {
    if (this.codigoBusqueda.trim()) {
      const payload = { cod_guia_remision: this.codigoBusqueda.trim() };
      this.informeService.getInformePorGuia(payload).subscribe(data => {
        this.informes = data;
      });
    }
  }
}
