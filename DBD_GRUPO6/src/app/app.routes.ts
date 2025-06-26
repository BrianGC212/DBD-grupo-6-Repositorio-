import { Routes } from '@angular/router';
import { Sidebar } from './components/sidebar/sidebar';
import { GestionEquipos } from './components/modulo_3/gestion-equipos/gestion-equipos';
import { EquiposRegistrados } from './components/modulo_3/equipos-registrados/equipos-registrados';
import { PlanificacionEquipos } from './components/modulo_3/planificacion-equipos/planificacion-equipos';
import { ProgramacionMantenimiento } from './components/modulo_3/programacion-mantenimiento/programacion-mantenimiento';
import { VisualizarProgramaciones } from './components/modulo_3/visualizar-programaciones/visualizar-programaciones';
import { PreparacionPedidos } from './components/modulo_1/preparacion-pedidos/preparacion-pedidos';
import { ListasPicking } from './components/modulo_1/listas-picking/listas-picking';
import { HistorialEquipos } from './components/modulo_3/historial-equipos/historial-equipos';


export const routes: Routes = [
    { path: '', redirectTo: 'sidebar', pathMatch: 'full' },
    { path: 'sidebar', component: Sidebar},
    {path: 'gestion-equipos', component: GestionEquipos},
    {path: 'equipos-registrados', component:EquiposRegistrados},
    {path: 'planificacion-equipos', component:PlanificacionEquipos},
    {path:'programacion-mantenimiento',component:ProgramacionMantenimiento},
    {path: 'visualizar-programaciones', component:VisualizarProgramaciones},
    {path:"preparacion-pedidos",component:PreparacionPedidos},
    {path:"pickings",component:ListasPicking},
    {path:"historial-equipos",component:HistorialEquipos},
    { path: '**', redirectTo: 'sidebar' }
];
