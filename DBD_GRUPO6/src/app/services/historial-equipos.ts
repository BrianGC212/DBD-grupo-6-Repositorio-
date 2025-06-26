import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HistorialEquipo } from '../components/modulo_3/models/models';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HistorialEquiposService {
  URL_API: string = 'http://localhost:8080/historial/'

  constructor(private http: HttpClient) { }

  getHistorialEquipos():Observable<HistorialEquipo[]> {
    return this.http.get<HistorialEquipo[]>(this.URL_API + 'equipos').pipe(map(res => res));
  }

}
