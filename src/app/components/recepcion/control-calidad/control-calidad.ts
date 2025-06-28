import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { recepcion } from '../../models/models';
import { RecepcionService } from '../../../services/recepcion/recepcion';
import { Router, NavigationEnd, RouterModule } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-control-calidad',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './control-calidad.html',
  styleUrls: ['./control-calidad.css']
})

export class ControlCalidad implements OnInit {
  recepciones: recepcion[] = [];
  cargando: boolean = true;

  constructor(
    private recepcionService: RecepcionService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
      this.cargarDatos();
    });
  }

  ngOnInit(): void {
    this.cargarDatos();
  }

  cargarDatos() {
    console.log('Ejecutando cargarDatos...');
    this.cargando = true;
    this.recepcionService.visualizarRecepciones().subscribe({
      next: data => {
        console.log('Datos recibidos:', data);
        this.recepciones = data;
        this.cargando = false;
        this.cdr.detectChanges(); // <-- Asegura que Angular actualice la vista
      },
      error: err => {
        console.error('Error cargando recepciones:', err);
        this.cargando = false;
        this.cdr.detectChanges();
      }
    });
  }
}