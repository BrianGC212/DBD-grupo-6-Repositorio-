import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { GuiaDetalle, GuiaRemision, GuiaRemisionInput } from '../components/models/models';
@Injectable({
  providedIn: 'root'
})
export class GuiasRemisionService {
  private URL_API = 'http://localhost:8080/transporte/';

  constructor(private http: HttpClient) {}

  getGuias(): Observable<GuiaRemision[]> {
    return this.http.get<GuiaRemision[]>(this.URL_API + 'guiaRemision').pipe(map(res => res));
  }
  registrarGuia(data: GuiaRemisionInput): Observable<any> {
    return this.http.post(this.URL_API + 'registrarGuia', data, { responseType: 'text' });
  }

  getDetalleGuia(codigo: string): Observable<GuiaDetalle[]> {
    return this.http.post<GuiaDetalle[]>(this.URL_API + 'detalleGuia', { guiaDetalle: codigo });
  }
}
