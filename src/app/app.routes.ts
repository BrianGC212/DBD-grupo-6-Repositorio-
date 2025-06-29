import { Routes } from '@angular/router';
import { MainLayout } from './components/layout/main-layout';
import { DashboardRecepcion } from './components/recepcion/dashboard-recepcion/dashboard-recepcion';
import { VisualizarLotes } from './components/recepcion/visualizar-lotes/visualizar-lotes';
import { ControlCalidad } from './components/recepcion/control-calidad/control-calidad';
import { GeneracionReportes } from './components/recepcion/generacion-reportes/generacion-reportes';
import { GestionEquipos } from './components/gestion-equipos/gestion-equipos';
import { EquiposRegistrados } from './components/equipos-registrados/equipos-registrados';
import { PlanificacionEquipos } from './components/planificacion-equipos/planificacion-equipos';
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
import { InicioTrazabilidad } from './components/trazabilidad/inicio-trazabilidad/inicio-trazabilidad';
import {VisualizarProceso} from './components/trazabilidad/visualizar-proceso/visualizar-proceso';
import {VisualizarReporteTrazabilidad} from './components/trazabilidad/visualizar-reporte-trazabilidad/visualizar-reporte-trazabilidad';
import {VisualizarIncidencias } from './components/trazabilidad/visualizar-incidencias/visualizar-incidencias';


export const routes: Routes = [
  {
    path: '',
    component: MainLayout,
    children: [
      { path: '', redirectTo: 'dashboard-recepcion', pathMatch: 'full' },
      { path: 'dashboard-recepcion', component: DashboardRecepcion },
      { path: 'visualizar-lotes', component: VisualizarLotes },
      { path: 'control-calidad', component: ControlCalidad },
      { path: 'reportes-recepcion', component: GeneracionReportes },
      { path: 'gestion-equipos', component: GestionEquipos },
      { path: 'equipos-registrados', component: EquiposRegistrados },
      { path: 'planificacion-equipos', component: PlanificacionEquipos },
      { path: 'gestion-transporte', component: InicioGestionTransporte },
      { path: 'gestion-transporte/ordenes', component: VisualizarOrdenesTransporte },
      { path: 'gestion-transporte/guias', component: VisualizarGuiasRemision },
      { path: 'gestion-transporte/informes', component: VisualizarInformeEntrega },
      { path: 'gestion-transporte/incidentes', component: VisualizarReporteIncidente },
      { path: 'gestion-transporte/registrar-guia', component: RegistrarGuiaRemision },
      { path: 'gestion-transporte/seguimiento', component: Seguimiento },
      { path: 'gestion-transporte/registrar-seguimiento', component: RegistrarSeguimiento },
      { path: 'gestion-transporte/registrar-informe-entrega', component: RegistrarInformeEntrega },
      { path: 'gestion-transporte/registrar-orden', component: RegistrarOrdenTransporte }
      { path: 'trazabilidad', component: InicioTrazabilidad },
    { path: 'trazabilidad/procesos', component: VisualizarProceso },
    { path: 'trazabilidad/reporte', component: VisualizarReporteTrazabilidad },
    { path: 'trazabilidad/incidencias', component: VisualizarIncidencias},
    ]
  },
  { path: '**', redirectTo: '' }
];
