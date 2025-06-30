import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { recepcion, DetalleRecepcionCalidad, RecepcionConId } from '../../components/models/models';

@Injectable({
  providedIn: 'root'
})
export class RecepcionService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  visualizarRecepciones(): Observable<recepcion[]> {
    return this.http.get<recepcion[]>(`${this.baseUrl}/recepciones/visualizar`);
  }

  aprobarRecepcion(data: any): Observable<string> {
    return this.http.post(`${this.baseUrl}/recepcion/aprobar`, data, { responseType: 'text' });
  }

  observarRecepcion(data: any): Observable<string> {
    return this.http.post(`${this.baseUrl}/recepcion/observar`, data, { responseType: 'text' });
  }

  obtenerDetalleRecepcion(codRecepcion: string): Observable<DetalleRecepcionCalidad> {
    return this.http.get<DetalleRecepcionCalidad>(`${this.baseUrl}/control-calidad/recepcion/${codRecepcion}`);
  }

  obtenerRecepcionConId(codRecepcion: string): Observable<RecepcionConId> {
  return this.http.get<RecepcionConId>(`${this.baseUrl}/control-calidad/recepcion/${codRecepcion}`);
}

  aprobarControlCalidad(data: any): Observable<string> {
    return this.http.post(`${this.baseUrl}/control-calidad/aprobar`, data, { responseType: 'text' });
  }

  observarControlCalidad(data: any): Observable<string> {
    return this.http.post(`${this.baseUrl}/control-calidad/observar`, data, { responseType: 'text' });
  }
}

