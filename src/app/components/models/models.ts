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

