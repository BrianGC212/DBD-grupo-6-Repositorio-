import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Area, Empleado, Equipo, Estado, MantenimientoDto, MaquinaSustituta, ProgEquipoDto } from '../components/modulo_3/models/models';

@Injectable({
  providedIn: 'root'
})
export class ProgMantService {
  URL_API: string = 'http://localhost:8080/mantenimiento/'
  constructor(private http: HttpClient) { }

  programarMantenimiento(dto:MantenimientoDto):void{
    this.http.post(this.URL_API + 'registrar', dto).subscribe({
      next: (response) => {
        console.log('Mantenimiento registrado exitosamente:', response);
      },
      error: (error) => {
        console.error('Error al programar el mantenimiento:', error);
      }
    })}

  getEstadosMantenimiento(): Observable<Estado[]> {
    return this.http.get<Estado[]>(this.URL_API + 'getEstadosMantenimiento').pipe(map(res => res));
  }

  getEstadosEquipo(): Observable<Estado[]> {
    return this.http.get<Estado[]>(this.URL_API + 'getEstadosEquipo').pipe(map(res => res));
  }

  getMaquinasSustitutas(): Observable<MaquinaSustituta[]> {
    return this.http.get<MaquinaSustituta[]>(this.URL_API + 'getMaquinasSustitutas').pipe(map(res => res));
  }

}