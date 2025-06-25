import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { recepcion } from '../../components/models/models';

@Injectable({
  providedIn: 'root'
})
export class RecepcionService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  // Para visualizar recepciones (ruta especial /recepciones)
  visualizarRecepciones(): Observable<recepcion[]> {
    return this.http.get<recepcion[]>(`${this.baseUrl}/recepciones/visualizar`);
  }

  // Para registrar recepción como "aprobado"
  aprobarRecepcion(data: any): Observable<string> {
    return this.http.post(`${this.baseUrl}/recepcion/aprobar`, data, { responseType: 'text' });
  }

  // Para registrar recepción como "observado"
  observarRecepcion(data: any): Observable<string> {
    return this.http.post(`${this.baseUrl}/recepcion/observar`, data, { responseType: 'text' });
  }
}

