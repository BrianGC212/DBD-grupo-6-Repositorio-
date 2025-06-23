import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { SeguimientoI, SeguimientoInput } from '../components/models/models';
@Injectable({
  providedIn: 'root'
})
export class SeguimientoService {
  private URL_API = 'http://localhost:8080/transporte/';

  constructor(private http: HttpClient) {}

  getSeguimientos(): Observable<SeguimientoI[]> {
    return this.http.get<SeguimientoI[]>(this.URL_API + 'seguimiento').pipe(
      map(res => res)
    );
  }
  getSeguimientoPorOrden(dto: { cod_orden_transporte: string }): Observable<SeguimientoI[]> {
    return this.http.post<SeguimientoI[]>(this.URL_API + 'seguimientoPorOrden', dto);
  }
  registrarSeguimiento(dto: SeguimientoInput): Observable<any> {
    return this.http.post<any>(this.URL_API + 'registrarSeg', dto);
  }
  
}
