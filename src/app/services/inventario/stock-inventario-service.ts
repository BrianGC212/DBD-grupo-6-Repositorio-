import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StockProducto } from '../../components/models/models';
import { AlertaInventario } from '../../components/models/models';

@Injectable({
    providedIn: 'root',
})
export class StockInventarioService {
    private readonly baseUrlStock = 'http://localhost:8080/stock';
    private readonly baseUrlAlertas = 'http://localhost:8080/alertas-inventario';

    constructor(private http: HttpClient) {}

    // Método para obtener todos los stocks
    obtenerTodosLosStocks(): Observable<StockProducto[]> {
        return this.http.get<StockProducto[]>(`${this.baseUrlStock}/visualizar`);
    }

    // Método para la barra de búsqueda
    buscarStockPorNombre(nombreProducto: string): Observable<StockProducto[]> {
        return this.http.get<StockProducto[]>(
            `${this.baseUrlStock}/buscar/${nombreProducto}`
        );
    }

    // Método para visualizar las alertas de inventario
    obtenerAlertasInventario(): Observable<AlertaInventario[]> {
        return this.http.get<AlertaInventario[]>(
            `${this.baseUrlAlertas}/visualizar`
        );
    }
}