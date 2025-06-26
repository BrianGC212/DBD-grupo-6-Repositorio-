import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Lote, Picking, ProductoPicking } from '../components/modulo_1/models/models';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PreparacionPedidosService {
  URL_API: string = 'http://localhost:8080/pedidos/'
  constructor(private http: HttpClient) { }


  getPikcings(param:String): Observable<Picking[]> {
    console.log(this.URL_API + 'getPickings?param='+param);
    return this.http.get<Picking[]>(this.URL_API + 'getPickings?param='+param).pipe(map(res => res));
  }

  getProductoPicking():Observable<ProductoPicking[]>{
    return this.http.get<ProductoPicking[]>(this.URL_API + 'getProductosPicking').pipe(map(res => res));
  }

  getLotes(producto: string): Observable<Lote[]> {
    return this.http.get<Lote[]>(this.URL_API + 'getLotes?param=' + producto).pipe(map(res => res));
  }

  registrarEmpaque(dto: any): Observable<any> {
    return this.http.post(this.URL_API + 'nuevoEmpaque', dto).pipe(map(res => res));
  }
}
