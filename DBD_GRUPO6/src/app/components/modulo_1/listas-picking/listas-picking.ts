import { Component, OnInit } from '@angular/core';
import { Sidebar } from '../../sidebar/sidebar';
import { CommonModule } from '@angular/common';
import { Lote, Picking, ProductoPicking } from '../models/models';
import { PreparacionPedidosService } from '../../../services/preparacion-pedidos-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-listas-picking',
  standalone: true,
  imports: [Sidebar,CommonModule,FormsModule],
  templateUrl: './listas-picking.html',
  styleUrl: './listas-picking.css'
})
export class ListasPicking implements OnInit {
  searchTerm:string='';
  pickings:Picking[] = [];
  showModal: boolean = false;
  showEmpaqueModal: boolean = false;
  productoReferencia: ProductoPicking|null = null;
  nombreEmpaque: string = '';
  id_tipo_empaque: string = '';
  pesoNeto: number = 0;
  descripcion: string = '';
  lotes:Lote[]=[];
  codigoLote: string = '';

  resultados:ProductoPicking[] = [];

  constructor(private s:PreparacionPedidosService){

  }

  ngOnInit():void{
    this.loadPickings('');
    this.loadProducts();
  }

  loadLotes(producto: string): void {
    this.s.getLotes(producto).subscribe({
      next: (data:Lote[]) => {
        this.lotes = data;
        console.log('Lotes cargados:', this.lotes);
      },
      error: err => console.error('Error al cargar lotes:', err)
    });
  }

  openEmpaqueModal(producto:ProductoPicking): void {
    this.showEmpaqueModal = true;
    this.loadLotes(producto.producto);
    this.productoReferencia = producto;
  }

  closeEmpaqueModal(): void {
    this.showEmpaqueModal = false;
    this.productoReferencia = null;
  }

  loadProducts():void{

    this.s.getProductoPicking().subscribe({
      next: (data:ProductoPicking[]) => {
        this.resultados = data;
        console.log('Productos cargados:', this.resultados);
      },
      error: err => console.error('Error al cargar productos:', err)
    });
  }

  onSearchInput(value: string): void {
    this.searchTerm = value.trim(); // Guarda si deseas
    this.loadPickings(this.searchTerm);
  }

  loadPickings(term: string): void {
  console.log('valor correcto:', term); // este SÍ es el valor actual
  this.s.getPikcings(term).subscribe({
    next: data => this.pickings = data
  });
}

  openModal(): void {
    this.showModal = true;
  }

  closeModal(): void {
    this.showModal = false;
  }


  registrarEmpaque():void{
      const empaqueData = {
        nombre: this.nombreEmpaque,
        id_tipo_empaque: this.id_tipo_empaque,
        descripcion: this.descripcion,
        capacidad_maxima: this.pesoNeto,
        id_lote: this.codigoLote
      };

      console.log('Datos del empaque:', empaqueData);

      // Aquí puedes llamar al servicio para registrar el empaque
      // Por ejemplo:
      this.s.registrarEmpaque(empaqueData).subscribe({
        next: response => {
          console.log('Empaque registrado exitosamente:', response);
        },
        error: err => {
          console.error('Error al registrar empaque:', err);
        }
      });
  }

  onLoteChange(): void {
    console.log('Lote seleccionado:', this.codigoLote);
  }

}
