import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Sidebar } from '../../sidebar/sidebar';

@Component({
  selector: 'app-control-inventarios',
  templateUrl: './control-inventarios.html',
  styleUrls: ['./control-inventarios.css'],
  standalone: true,
  imports: []
})
export class ControlInventarios {

  constructor(private router: Router) {}

  irA(ruta: string) {
  this.router.navigate([`/${ruta}`]);
}

}