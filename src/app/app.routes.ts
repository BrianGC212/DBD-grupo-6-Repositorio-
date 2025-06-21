import { Routes } from '@angular/router';
import { Sidebar } from './components/sidebar/sidebar';
import { GestionEquipos } from './components/gestion-equipos/gestion-equipos';
import { EquiposRegistrados } from './components/equipos-registrados/equipos-registrados';
import { PlanificacionEquipos } from './components/planificacion-equipos/planificacion-equipos';
import { VisualizarLotes } from './components/recepcion/visualizar-lotes/visualizar-lotes';
import { DashboardRecepcion } from './components/recepcion/dashboard-recepcion/dashboard-recepcion';
import { ControlCalidad } from './components/recepcion/control-calidad/control-calidad';
import { GeneracionReportes } from './components/recepcion/generacion-reportes/generacion-reportes';

export const routes: Routes = [
    { path: '', redirectTo: 'sidebar', pathMatch: 'full' },
    { path: 'sidebar', component: Sidebar},
    { path: 'dashboard-recepcion', component: DashboardRecepcion },
    {path: 'gestion-equipos', component: GestionEquipos},
    {path: 'equipos-registrados', component:EquiposRegistrados},
    {path: 'planificacion-equipos', component:PlanificacionEquipos},
    { path: 'visualizar-lotes', component: VisualizarLotes },
    { path: 'control-calidad', component: ControlCalidad },
    { path: 'reportes-recepcion', component: GeneracionReportes },
    { path: '**', redirectTo: 'sidebar' }
];
