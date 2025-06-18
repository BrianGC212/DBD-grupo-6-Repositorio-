// LOGISTICA_AGROVISION/log-agrov-frontend/src/app/app.routes.ts

import { Routes } from '@angular/router';
import { CalendarioComponent } from './calendario/calendario';
import { GestionEquiposComponent } from './app/gestion-equipos/gestion-equipos';
import { EquiposRegistradosComponent } from './app/equipos-registrados/equipos-registrados';
export const routes: Routes = [
  { path: '', redirectTo: '/gestion-equipos', pathMatch: 'full' },
  { path: 'gestion-equipos', component: GestionEquiposComponent },
  { path: 'equipos-registrados', component: EquiposRegistradosComponent },
  { path: 'calendario', component: CalendarioComponent }, // Ensure this path is correct if you have this component
  { path: '**', redirectTo: '/gestion-equipos' }
];
