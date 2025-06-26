import { Component, OnInit, OnDestroy } from '@angular/core';
import { Sidebar } from '../../sidebar/sidebar';
import { CommonModule } from '@angular/common';
import { Historial, Maquina } from '../models/models';
import { GestionEquiposService } from '../../../services/gestion-equipos-service';
import { ActivatedRoute, Router, NavigationEnd } from '@angular/router';
import { filter, takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-equipos-registrados',
  imports: [Sidebar, CommonModule],
  templateUrl: './equipos-registrados.html',
  styleUrl: './equipos-registrados.css'
})
export class EquiposRegistrados implements OnInit, OnDestroy {
  maquinolas: Maquina[] = [];
  historialData: Historial[] = [];
  showModal: boolean = false;
  loading: boolean = true;
  error: string | null = null;

  private destroy$ = new Subject<void>();

  constructor(
    private gES: GestionEquiposService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    // Opción 2: Forzar recarga al navegar a la misma ruta
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  ngOnInit() {
    this.loadData();

    // Opción 1: Escuchar eventos de navegación
    this.router.events
      .pipe(
        filter(event => event instanceof NavigationEnd),
        takeUntil(this.destroy$)
      )
      .subscribe(() => {
        this.loadData();
      });
  }

  loadData() {
    this.loading = true;
    this.error = null;

    this.gES.getListado().subscribe({
      next: (data: Maquina[]) => {
        this.maquinolas = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Error al cargar los equipos';
        this.loading = false;
        console.error('Error:', err);
      }
    });
  }

  openHistorialModal(codigo: string) {
    this.gES.getHistorial(codigo).subscribe({
      next: (data: Historial[]) => {
        this.historialData = data;
        this.showModal = true;
      },
      error: (err) => {
        this.error = 'Error al cargar el historial';
        console.error('Error:', err);
      }
    });
  }

  closeModal() {
    this.showModal = false;
  }

  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }
}