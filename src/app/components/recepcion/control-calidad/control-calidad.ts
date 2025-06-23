import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { recepcion } from '../../models/models';
import { RecepcionService } from '../../../services/recepcion/recepcion';
import { Sidebar } from '../../sidebar/sidebar';

@Component({
  selector: 'app-control-calidad',
  standalone: true,
  imports: [Sidebar, CommonModule],
  templateUrl: './control-calidad.html',
  styleUrl: './control-calidad.css'
})
export class ControlCalidad implements OnInit{

  recepciones: recepcion[] = [];

  constructor(private recepcionService: RecepcionService) {}

  ngOnInit(): void {
    this.recepcionService.visualizarRecepciones().subscribe({
      next: (data) => this.recepciones = data,
      error: (err) => console.error('Error al obtener los lotes', err)
    });
  }
}

