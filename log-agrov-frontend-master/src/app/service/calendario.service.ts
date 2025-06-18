import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProgramacionCalendario } from '../models/programacion-calendario';

@Injectable({
  providedIn: 'root'
})
export class CalendarioService {

  private baseUrl = 'http://localhost:8080/maquinas';

  constructor(private http: HttpClient) { }

  getProgramacionAsignacion(fecha: string): Observable<ProgramacionCalendario[]> {
    const params = new HttpParams().set('fecha', fecha);
    return this.http.get<ProgramacionCalendario[]>(`${this.baseUrl}/programarAsignacion`, { params });
  }
}
