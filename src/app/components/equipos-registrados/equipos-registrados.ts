import { Component, OnInit } from '@angular/core';
import { Sidebar } from '../sidebar/sidebar';
import { CommonModule } from '@angular/common';
import { Historial, Maquina } from '../models/models';
import { GestionEquiposService } from '../../services/gestion-equipos-service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-equipos-registrados',
  imports: [Sidebar,CommonModule],
  templateUrl: './equipos-registrados.html',
  styleUrl: './equipos-registrados.css'
})
export class EquiposRegistrados implements OnInit {
  maquinolas: Maquina[] = [];

  historialData:Historial[] = [];

  constructor(private gES:GestionEquiposService){
    this.gES.getListado().subscribe((data: Maquina[]) => {
      this.maquinolas = data;
      console.log(data);
      console.log(this.maquinolas);
    });
  }

  ngOnInit() {
    
  }

  showModal: boolean = false;

  openHistorialModal(codigo: string) {
    this.gES.getHistorial(codigo).subscribe((data: any[]) => {
      this.historialData = data;
      this.showModal = true;
    });
  }




  // Método para cerrar el modal
  closeModal() {
    this.showModal = false;
  }

}
