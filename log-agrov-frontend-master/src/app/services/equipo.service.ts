
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Equipo } from '../models/equipo';
import { HistorialEstado } from '../models/historial-estado';

@Injectable({
  providedIn: 'root'
})
export class EquipoService {
  private baseUrl = 'http://localhost:8080/equipos';

  constructor(private http: HttpClient) { }

  obtenerEquipos(): Observable<Equipo[]> {
    return this.http.get<Equipo[]>(`${this.baseUrl}/listar`);
  }

  obtenerHistorialEstado(codEquipo: string): Observable<HistorialEstado[]> {
    return this.http.get<HistorialEstado[]>(`<span class="math-inline">\{this\.baseUrl\}/historial/</span>{codEquipo}`);
  }
}
