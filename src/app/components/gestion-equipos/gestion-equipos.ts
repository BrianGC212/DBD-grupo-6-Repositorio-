import { Component } from '@angular/core';
import { Sidebar } from '../sidebar/sidebar';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-gestion-equipos',
  imports: [
    Sidebar, RouterModule
  ],
  templateUrl: './gestion-equipos.html',
  styleUrl: './gestion-equipos.css'
})
export class GestionEquipos {
  
}
