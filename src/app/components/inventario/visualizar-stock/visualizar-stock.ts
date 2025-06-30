import { Component, OnInit } from '@angular/core';
import { StockInventarioService } from '../../../services/inventario/stock-inventario-service';
import { StockProducto, AlertaInventario } from '../../models/models';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

@Component({
    selector: 'app-visualizar-stock',
    templateUrl: './visualizar-stock.html',
    styleUrls: ['./visualizar-stock.css'],
    imports: [BrowserModule,FormsModule,],
})
export class VisualizarStockComponent implements OnInit {
    stocks: StockProducto[] = [];
    alertas: AlertaInventario[] = [];
    searchQuery: string = '';
    mostrarAlertas: boolean = false;

    constructor(private stockService: StockInventarioService) {}

    ngOnInit(): void {
        this.cargarStocks();
    }

    // Cargar todos los stocks
    cargarStocks(): void {
        this.stockService.obtenerTodosLosStocks().subscribe(
            (data) => {
                this.stocks = data;
            },
            (error) => {
                console.error('Error al cargar los stocks:', error);
            }
        );
    }

}