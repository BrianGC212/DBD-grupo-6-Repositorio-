import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Lote } from '../../components/models/models';
// Asegúrate de que esta ruta apunte donde definiste la interfaz

@Injectable({
  providedIn: 'root'
})
export class LoteService {

  private apiUrl = 'http://localhost:8080/lotes'; // Cambia esto por tu URL real del backend

  constructor(private http: HttpClient) { }

  obtenerLotes(): Observable<Lote[]> {
    return this.http.get<Lote[]>(`${this.apiUrl}/visualizar`);
  }
}
