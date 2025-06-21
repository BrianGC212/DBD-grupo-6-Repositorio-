import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Lote } from '../../models/models';
import { LoteService } from '../../../services/recepcion/lote';

@Component({
  selector: 'app-visualizar-lotes',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './visualizar-lotes.html',
  styleUrl: './visualizar-lotes.css'
})
export class VisualizarLotes implements OnInit {

  lotes: Lote[] = [];

  constructor(private loteService: LoteService) {}

  ngOnInit(): void {
    this.loteService.obtenerLotes().subscribe({
      next: (data) => this.lotes = data,
      error: (err) => console.error('Error al obtener los lotes', err)
    });
  }
}
