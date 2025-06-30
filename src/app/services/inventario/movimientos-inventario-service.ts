import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MovimientoInventario } from '../../components/models/models';

@Injectable({
    providedIn: 'root'
})
export class MovimientosInventarioService {
    private baseUrl = 'http://localhost:8080/movimientos-inventario';

    constructor(private http: HttpClient) {}

    // Método para obtener los movimientos de inventario
    obtenerMovimientosInventario(): Observable<MovimientoInventario[]> {
        return this.http.get<MovimientoInventario[]>(`${this.baseUrl}/visualizar`);
    }

    // Método para registrar un nuevo movimiento de inventario
    registrarMovimientoInventario(movimiento: MovimientoInventario): Observable<MovimientoInventario> {
        return this.http.post<MovimientoInventario>(`${this.baseUrl}/registrar`, movimiento);
    }
}