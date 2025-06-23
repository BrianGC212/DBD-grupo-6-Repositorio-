package logistica_agrovision.log_agrov.Dto.TransporteDto;

public class VisualizarSeguimientoPorOrdenDto {
    private String cod_orden_transporte;
    private String cod_empleado;
    private String descripcion;
    private String fecha_registro;
    private String hora_registro;
    private String estado;

    public String getCod_orden_transporte() {
        return cod_orden_transporte;
    }

    public void setCod_orden_transporte(String cod_orden_transporte) {
        this.cod_orden_transporte = cod_orden_transporte;
    }

    public String getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(String cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getHora_registro() {
        return hora_registro;
    }

    public void setHora_registro(String hora_registro) {
        this.hora_registro = hora_registro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
