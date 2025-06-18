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
