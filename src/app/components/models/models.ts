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

export interface Lote {
    cod_lote: string
    nombre_producto: string
    tipo_del_lote: string
    fecha_produccion: string
    cantidad: number
    unidad: string
    estado_lote: string
}

export interface recepcion {
    cod_recepcion: string
    nombre_producto: string
    descripcion_lote: string
    cantidad: number
    unidad: string
    estado_recepcion: string
}

export interface LoteRecepcionVista {
  cod_lote: string;
  nombre_producto: string;
  cantidad: number;
  unidad: string;
}

export interface OrdenTransporte {
    cod_orden_transporte: string;
    cod_empleado: string;
    fecha_salida: string;
    hora_salida: string;
    fecha_finalizada: string | null;
    descripcion: string;
}

export interface GuiaRemision{
    cod_orden_transporte: string;
    cod_guia_remision: string;
    cod_empleado: string;
    placa_vehiculo: string;
    tipo_vehiculo: string;
    fecha_de_traslado: string;
    entregado: string;
}

export interface InformeEntrega{
    cod_guia_remision: string;
    cod_empleado: string;
    nombre_receptor: string;
    dni_receptor: string;
    fecha_entrega: string;
    hora_entrega: string;
    observacion: string;
}

export interface ReporteIncidenteEntrega{
    cod_guia_remision: string;
    cod_empleado: string;
    cod_cliente: string;
    nombre_realiza: string;
    dni_realiza: string;
    fecha_registro: string;
    hora_registro: string;
    estado: string;
    descripcion: string;
}

export interface GuiaRemisionInput {
    fecha_de_traslado: string;
    placa_vehiculo: string;
    cod_empleado: string;
    cod_pedido: string;
    cod_transportista: string;
}

export interface GuiaDetalle {
    codProducto: string;
    nombre: string;
    peso: string;
    unidad: string;
}

export interface SeguimientoI {
    cod_orden_transporte: string;
    cod_empleado: string;
    descripcion: string;
    fecha_registro: string;
    hora_registro: string;
    estado: string;
}
export interface SeguimientoInput {
    descripcion: string;
    id_estado_seguimiento: string;
    cod_orden_transporte: string;
}

export interface InformeEtregaInput{
    nombre_receptor: string;
    dni_receptor: string;
    observacion: string;
    cod_guia_remision: string;
}
export interface OrdenTransporteInput {
    fecha_salida: string;
    hora_salida: string;
    cod_empleado: string;
    guiasRemision: string[];
}

export interface MovimientoInventario {
    codMovimientoInventario: string;
    fechaMovimiento: string; // Use string for ISO date, or Date if you prefer
    codLote: string;
    destino: string;
    tipoMovimientoDescripcion: string;
    codEmpleado: string;
}
export interface StockProducto {
    nombreProducto: string;
    stockDisponible: number;
    stockMinimo: number;
    stockMaximo: number;
}

export interface AlertaInventario {
    codAlertaInventario: string;
    estadoAlerta: string;
    tipoAlerta: string;
    severidad: string;
    descripcion: string;
    fechaHoraAlerta: string; // Use string for ISO date-time, or Date if you prefer
    fechaHoraSolucion: string | null;
    codLote: string;
    idEmpleado: number;
}
