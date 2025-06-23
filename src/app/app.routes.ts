import { Routes } from '@angular/router';
import { Sidebar } from './components/sidebar/sidebar';
import { GestionEquipos } from './components/gestion-equipos/gestion-equipos';
import { EquiposRegistrados } from './components/equipos-registrados/equipos-registrados';
import { PlanificacionEquipos } from './components/planificacion-equipos/planificacion-equipos';
import { VisualizarLotes } from './components/recepcion/visualizar-lotes/visualizar-lotes';
import { DashboardRecepcion } from './components/recepcion/dashboard-recepcion/dashboard-recepcion';
import { ControlCalidad } from './components/recepcion/control-calidad/control-calidad';
import { GeneracionReportes } from './components/recepcion/generacion-reportes/generacion-reportes';
import { VisualizarOrdenesTransporte } from './components/gestion-transporte/visualizar-ordenes-transporte/visualizar-ordenes-transporte';
import { InicioGestionTransporte } from './components/gestion-transporte/inicio-gestion-transporte/inicio-gestion-transporte';
import { VisualizarGuiasRemision } from './components/gestion-transporte/visualizar-guias-remision/visualizar-guias-remision';
import { VisualizarInformeEntrega } from './components/gestion-transporte/visualizar-informe-entrega/visualizar-informe-entrega';
import { VisualizarReporteIncidente } from './components/gestion-transporte/visualizar-reporte-incidente/visualizar-reporte-incidente';
import { RegistrarGuiaRemision } from './components/gestion-transporte/registrar-guia-remision/registrar-guia-remision';
import { Seguimiento } from './components/gestion-transporte/seguimiento/seguimiento';
import { RegistrarSeguimiento } from './components/gestion-transporte/registrar-seguimiento/registrar-seguimiento';
import { RegistrarInformeEntrega } from './components/gestion-transporte/registrar-informe-entrega/registrar-informe-entrega';
import { RegistrarOrdenTransporte } from './components/gestion-transporte/registrar-orden-transporte/registrar-orden-transporte';

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
    {path: 'gestion-transporte', component:InicioGestionTransporte},
    {path: 'gestion-transporte/ordenes', component:VisualizarOrdenesTransporte},
    { path: 'gestion-transporte/guias', component: VisualizarGuiasRemision },
    { path: 'gestion-transporte/informes', component: VisualizarInformeEntrega },
    { path: 'gestion-transporte/incidentes', component: VisualizarReporteIncidente },
    {path: 'gestion-transporte/registrar-guia', component: RegistrarGuiaRemision},
    {path: 'gestion-transporte/seguimiento', component: Seguimiento},
    {path: 'gestion-transporte/registrar-seguimiento',component: RegistrarSeguimiento},
    { path: 'gestion-transporte/registrar-informe-entrega', component: RegistrarInformeEntrega },
    { path: 'gestion-transporte/registrar-orden', component: RegistrarOrdenTransporte },
    { path: '**', redirectTo: 'sidebar' }
];
