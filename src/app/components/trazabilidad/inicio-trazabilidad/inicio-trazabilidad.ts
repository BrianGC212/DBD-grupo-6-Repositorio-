import { Component } from '@angular/core';
import { Sidebar } from '../../sidebar/sidebar';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-inicio-trazabilidad',
  standalone: true,
  imports: [Sidebar,RouterModule,CommonModule],
  templateUrl: './inicio-trazabilidad.html',
  styleUrls: ['./inicio-trazabilidad.css']
})
export class InicioTrazabilidad{

}
