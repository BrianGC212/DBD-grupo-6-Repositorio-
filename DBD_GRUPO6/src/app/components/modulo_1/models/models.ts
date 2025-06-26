export interface Picking {
    pedido: string;
    nombre_empleado: string;
    fecha_limite: string;
    destino: string;
    estado: string;
}

export interface ProductoPicking {
    id_producto: string;
    producto: string;
    cantidad: number;
    area: string;
    estado: string;
}

export interface Lote{
    id_lote:string;
    cod_lote:string;
}

export interface RegistrarEmpaqueDto {
    nombre: string;
    id_tipo_empaque: string;
    descripcion: string;
    capacidad_maxima: number;
    id_lote: number;
}
