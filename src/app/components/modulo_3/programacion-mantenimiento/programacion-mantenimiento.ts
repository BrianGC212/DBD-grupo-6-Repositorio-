import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Sidebar } from '../../sidebar/sidebar';
import { Equipo, Estado, MantenimientoDto, MaquinaSustituta } from '../models/models';
import { ProgEquiposService } from '../../../services/progEquiposService';
import { ProgMantService } from '../../../services/progMantenimientoService';

@Component({
  selector: 'app-programacion-mantenimiento',
  imports: [CommonModule,FormsModule],
  templateUrl: './programacion-mantenimiento.html',
  styleUrl: './programacion-mantenimiento.css'
})
export class ProgramacionMantenimiento implements OnInit {
  dto: MantenimientoDto = {
    codigoEquipo: 0,
    fechaInicio: '',
    codigoMantenimiento: '',
    codigoMaquinaSustituta: 0,
    empresaEncargada: '',
    idEstadoEquipo: '',
    idEstadoMantenimiento: '',
    idEmpleadoRegistra: 1,
    idEmpleadoSolicita: 2
  }

  listadoEquipos:Equipo[]=[];
  listadoEstadosEquipo:Estado[]=[];
  listadoEstadosMantenimiento:Estado[]=[];
  listadoMaquinasSustitutas:MaquinaSustituta[]=[];

  constructor(private pES:ProgEquiposService,private pMS:ProgMantService) {
    // Aquí podrías cargar los datos necesarios para el componente
  }

  ngOnInit(): void {
    this.pES.getEquipos().subscribe({
      next: (res: Equipo[]) => {
        this.listadoEquipos = res;
      }
    });
    this.pMS.getEstadosEquipo().subscribe({
      next: (res: Estado[]) => {
        this.listadoEstadosEquipo = res;
      }
    });
    this.pMS.getEstadosMantenimiento().subscribe({
      next: (res: Estado[]) => {
        this.listadoEstadosMantenimiento = res;
      }
    });
    this.pMS.getMaquinasSustitutas().subscribe({
      next: (res: MaquinaSustituta[]) => {
        this.listadoMaquinasSustitutas = res;
      }
    });
  }

  asignarMantenimiento(): void {
    console.log(this.dto);
    this.pMS.programarMantenimiento(this.dto);
  }

}
