import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { OrdenTransporte, OrdenTransporteInput } from '../components/models/models';

@Injectable({
  providedIn: 'root'
})
export class OrdenesTransporteService {
  URL_API: string = 'http://localhost:8080/transporte/'
  constructor(private http: HttpClient) { }
  
    getListado(): Observable<OrdenTransporte[]> {
      return this.http.get<OrdenTransporte[]>(this.URL_API + 'ordenes').pipe(map(res => res));
    }
    obtenerGuiasPorOrden(payload: { cod_orden_transporte: string }): Observable<any[]> {
      return this.http.post<any[]>('http://localhost:8080/transporte/ordenxguiaPorOrden', payload);
    }
    registrarOrdenTransporte(data: OrdenTransporteInput): Observable<any> {
      return this.http.post(`${this.URL_API}registrarOrdenTransporte`, data);
    }

}
