import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { recepcion } from '../../models/models';
import { RecepcionService } from '../../../services/recepcion/recepcion';
import { Sidebar } from '../../sidebar/sidebar';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-control-calidad',
  standalone: true,
  imports: [Sidebar, CommonModule],
  templateUrl: './control-calidad.html',
  styleUrl: './control-calidad.css'
})
export class ControlCalidad implements OnInit {
  recepciones: recepcion[] = [];
  cargando: boolean = true;

  constructor(private recepcionService: RecepcionService) {}

  ngOnInit(): void {
    this.recepcionService.visualizarRecepciones().subscribe({
      next: (data) => {
        console.log('Recepciones cargadas:', data);
        this.recepciones = data;
        this.cargando = false;
      },
      error: (err) => {
        console.error('Error al obtener las recepciones', err);
        this.cargando = false;
      }
    });
  }
}



