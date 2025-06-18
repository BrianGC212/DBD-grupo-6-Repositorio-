import { Routes } from '@angular/router';
import { Sidebar } from './components/sidebar/sidebar';
import { GestionEquipos } from './components/gestion-equipos/gestion-equipos';
import { EquiposRegistrados } from './components/equipos-registrados/equipos-registrados';
import { PlanificacionEquipos } from './components/planificacion-equipos/planificacion-equipos';

export const routes: Routes = [
    { path: '', redirectTo: 'sidebar', pathMatch: 'full' },
    { path: 'sidebar', component: Sidebar},
    {path: 'gestion-equipos', component: GestionEquipos},
    {path: 'equipos-registrados', component:EquiposRegistrados},
    {path: 'planificacion-equipos', component:PlanificacionEquipos},
    { path: '**', redirectTo: 'sidebar' }
];
