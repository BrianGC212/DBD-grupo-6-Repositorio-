export interface Maquina {
    codigoMaquina: string;
    equipo: string;
    tipoMaquina: string;
    estadoMaquina: string;
    fechaRegistro: string;
    fechaSalida: string | null;
    detalle: string;
}

export interface Historial {
    fecha: string;
    estado: string;
    detalle: string;
}

export interface Empleado {
    id_empleado:number;
    nombre_apellido:string;
}

export interface Area{
    id_area:string;
    nombre:string;
}

export interface Equipo{
    idEquipo: number;
    nombre: string;
}

export interface ProgEquipoDto {
    idEquipo: number;
    fechaInicio: string; // Use string for ISO date, or Date if you prefer
    fechaFin: string;    // Use string for ISO date, or Date if you prefer
    descripcionTarea: string;
    idArea: string;
    idEmpleadoRegistra: number;
    idEmpleadoSolicita: number;
}

export interface MantenimientoDto {
    codigoMantenimiento: string;
    fechaInicio: string; // Use string for ISO date, or Date if you prefer
    empresaEncargada: string;
    codigoEquipo: number;
    idEstadoEquipo: string;
    idEstadoMantenimiento: string;
    idEmpleadoRegistra: number;
    idEmpleadoSolicita: number;
    codigoMaquinaSustituta: number;
}

export interface Estado {
    idEstado: string;
    descripcion: string;
}

export interface MaquinaSustituta {
    id_maq_sust:number;
    nombre:string;
}

export interface Programacion {
    cod_plan: string;
    equipo: string;
    area: string;
    responsable: string;
    fecha_inicio: string; // Use string for ISO date, or Date if you prefer
    fecha_fin: string;    // Use string for ISO date, or Date if you prefer
    descripcion: string;
}

export interface HistorialEquipo {
    codigoReporte: string;
    equipo: string;
    estado: string;
    cambioArea: string;
    fechaInicio: string;
    fechaFin: string;
    maquinaSustituta: string;
    detalle: string;
}
