package logistica_agrovision.log_agrov.Dto.TransporteDto;

public class VisualizarInformeEntregaPorGuiaDto {
    private String cod_guia_remision;
    private String cod_empleado;
    private String nombre_receptor;
    private String dni_receptor;
    private String fecha_entrega;
    private String hora_entrega;
    private String observacion;

    public String getCod_guia_remision() {
        return cod_guia_remision;
    }

    public void setCod_guia_remision(String cod_guia_remision) {
        this.cod_guia_remision = cod_guia_remision;
    }

    public String getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(String cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public String getNombre_receptor() {
        return nombre_receptor;
    }

    public void setNombre_receptor(String nombre_receptor) {
        this.nombre_receptor = nombre_receptor;
    }

    public String getDni_receptor() {
        return dni_receptor;
    }

    public void setDni_receptor(String dni_receptor) {
        this.dni_receptor = dni_receptor;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getHora_entrega() {
        return hora_entrega;
    }

    public void setHora_entrega(String hora_entrega) {
        this.hora_entrega = hora_entrega;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
