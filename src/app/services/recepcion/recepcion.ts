import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { recepcion } from '../../components/models/models';

@Injectable({
  providedIn: 'root'
})
export class RecepcionService {

  private apiUrl = 'http://localhost:8080/recepciones'; // Cambia esto por tu URL real del backend

  constructor(private http: HttpClient) { }

  visualizarRecepciones(): Observable<recepcion[]> {
    return this.http.get<recepcion[]>(`${this.apiUrl}/visualizar`);
  }
}
