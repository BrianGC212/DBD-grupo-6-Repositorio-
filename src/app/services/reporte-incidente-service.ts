import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { ReporteIncidenteEntrega } from '../components/models/models';
@Injectable({
  providedIn: 'root'
})
export class ReporteIncidenteService {
  URL_API: string = 'http://localhost:8080/transporte/'
  constructor(private http: HttpClient) { }
  
    getListado(): Observable<ReporteIncidenteEntrega[]> {
      return this.http.get<ReporteIncidenteEntrega[]>(this.URL_API + 'reporteIncidente').pipe(map(res => res));
    }
}
