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

