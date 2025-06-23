import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { InformeEntrega, InformeEtregaInput } from '../components/models/models';
@Injectable({
  providedIn: 'root'
})
export class InformeEntregaService {
  private URL_API = 'http://localhost:8080/transporte/';

  constructor(private http: HttpClient) {}
  getInformes(): Observable<InformeEntrega[]> {
    return this.http.get<InformeEntrega[]>(this.URL_API + 'informeEntrega').pipe(map(res => res));
  }
  registrarInforme(informe: InformeEtregaInput): Observable<any> {
    return this.http.post(this.URL_API + 'registrarInforme', informe);
  }
  getInformePorGuia(dto: { cod_guia_remision: string }): Observable<InformeEntrega[]> {
    return this.http.post<InformeEntrega[]>(this.URL_API + 'informePorGuia', dto);
  }
}
