import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Lote } from '../../models/models';
import { LoteService } from '../../../services/recepcion/lote';
import { Router } from '@angular/router';

@Component({
  selector: 'app-visualizar-lotes',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './visualizar-lotes.html',
  styleUrl: './visualizar-lotes.css'
})
export class VisualizarLotes implements OnInit {

  lotes: Lote[] = [];

  constructor(
  private router: Router,
  private loteService: LoteService
) {
  this.ngOnInit();
  // Previene la reutilización de rutas: obliga a Angular a recargar el componente
  this.router.routeReuseStrategy.shouldReuseRoute = () => false;
}

  ngOnInit(): void {
    this.loteService.obtenerLotes().subscribe({
      next: (data) => this.lotes = data,
      error: (err) => console.error('Error al obtener los lotes', err)
    });
  }
}
