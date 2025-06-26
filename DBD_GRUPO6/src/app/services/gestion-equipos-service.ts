import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Historial, Maquina } from '../components/modulo_3/models/models';

@Injectable({
  providedIn: 'root'
})
export class GestionEquiposService {
  URL_API: string = 'http://localhost:8080/equipos/'
  constructor(private http: HttpClient) { }

  getListado(): Observable<Maquina[]> {
    return this.http.get<Maquina[]>(this.URL_API + 'listar').pipe(map(res => res));
  }

  getHistorial(id:string):Observable<Historial[]>{
    return this.http.get<Historial[]>(this.URL_API + 'historial/' + id).pipe(map(res => res));
  }
}