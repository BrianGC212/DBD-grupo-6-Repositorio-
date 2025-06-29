import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs'; // Asegúrate de que 'Observable' esté importado
import { Area, Empleado, Equipo, ProgEquipoDto, Programacion } from '../components/modulo_3/models/models';

@Injectable({
  providedIn: 'root'
})
export class ProgEquiposService {
  URL_API: string = 'http://localhost:8080/maquinas/'; // Tu URL de API, esto está bien

  constructor(private http: HttpClient) { }

  // --- ¡CAMBIO CLAVE AQUÍ! ---
  // Ahora programarAsignacion devuelve el Observable, no se suscribe aquí
  programarAsignacion(dto: ProgEquipoDto): Observable<any> { // Se especifica que devuelve un Observable<any>
    return this.http.post<any>(this.URL_API + 'programarAsignacion', dto);
    // El .subscribe() se hará en el componente que llame a este método
  }

  getEmpleados(): Observable<Empleado[]> {
    return this.http.get<Empleado[]>(this.URL_API + 'listarEmpleados').pipe(map(res => res));
  }

  getEquipos(): Observable<Equipo[]> {
    return this.http.get<Equipo[]>(this.URL_API + 'listarEquipos').pipe(map(res => res));
  }

  getAreas(): Observable<Area[]> {
    return this.http.get<Area[]>(this.URL_API + 'listarAreas').pipe(map(res => res));
  }

  obtenerProgramaciones(): Observable<Programacion[]> {
    return this.http.get<Programacion[]>(this.URL_API + 'programaciones').pipe(map(res => res));
  }

  // --- ¡CAMBIO CLAVE TAMBIÉN AQUÍ si quieres manejar el éxito/error del borrado en el componente! ---
  // Ahora borrarProgramacion devuelve el Observable
  borrarProgramacion(codigo: string): Observable<any> { // Se especifica que devuelve un Observable<any>
    return this.http.delete<any>(this.URL_API + 'programar/' + codigo);
    // El .subscribe() también se hará en el componente que llame a este método si necesitas manejar la respuesta
  }
}
