import { Component } from '@angular/core';
import { Sidebar } from '../../sidebar/sidebar';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-inicio-gestion-transporte',
  standalone: true,
  imports: [Sidebar,RouterModule,CommonModule],
  templateUrl: './inicio-gestion-transporte.html',
  styleUrls: ['./inicio-gestion-transporte.css']
})
export class InicioGestionTransporte {

}
