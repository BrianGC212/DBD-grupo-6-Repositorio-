import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Sidebar } from '../../sidebar/sidebar';
import { RouterModule } from '@angular/router';
import { GuiasRemisionService } from '../../../services/guias-remision-service';
import { GuiaDetalle, GuiaRemision } from '../../models/models';

@Component({
  selector: 'app-visualizar-guias-remision',
  imports: [CommonModule,RouterModule],
  templateUrl: './visualizar-guias-remision.html',
  styleUrl: './visualizar-guias-remision.css'
})
export class VisualizarGuiasRemision implements OnInit{
  guias: GuiaRemision[] = [];
  detalleGuia: GuiaDetalle[] = [];
  showModal: boolean = false;
  guiaSeleccionada: string = '';
  
  constructor(private guiaService: GuiasRemisionService) {}

  ngOnInit(): void {
    this.guiaService.getGuias().subscribe(data => {
      this.guias = data;
    });
  }

  openDetalle(codGuia: string): void {
    this.guiaSeleccionada = codGuia;
    this.guiaService.getDetalleGuia(codGuia).subscribe(data => {
      this.detalleGuia = data;
      this.showModal = true;
    });
  }

  closeModal(): void {
    this.showModal = false;
    this.detalleGuia = [];
  }
}
