import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovimientosInventarioService } from '../../../services/inventario/movimientos-inventario-service';
import { MovimientoInventario } from '../../models/models';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';


@Component({
    selector: 'app-visualizar-movimientos-inventario',
    templateUrl: './visualizar-movimientos-inventario.html',
    styleUrls: ['./visualizar-movimientos-inventario.css'],
    standalone: true,
    imports: [
        CommonModule,
        FormsModule,
        MatTableModule,
        MatButtonModule
    ]
})
export class VisualizarMovimientosInventarioComponent implements OnInit {
    movimientosInventario: MovimientoInventario[] = [];
    isLoading: boolean = true;

    constructor(
        private movimientosInventarioService: MovimientosInventarioService,
        private router: Router
    ) {}

    ngOnInit(): void {
        this.cargarMovimientosInventario();
    }

    cargarMovimientosInventario(): void {
        this.movimientosInventarioService.obtenerMovimientosInventario().subscribe({
            next: (data) => {
                this.movimientosInventario = data;
                this.isLoading = false;
            },
            error: (err) => {
                console.error('Error al cargar los movimientos de inventario', err);
                this.isLoading = false;
            }
        });
    }

    irARegistrarMovimiento(): void {
        this.router.navigate(['/registrar-movimiento-inventario']);
    }
}