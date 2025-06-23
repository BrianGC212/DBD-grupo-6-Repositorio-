package logistica_agrovision.log_agrov.Dto.TransporteDto;

public class RegistrarSeguimientoDto {
    private String descripcion;
    private String id_estado_seguimiento;
    private String cod_orden_transporte;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_estado_seguimiento() {
        return id_estado_seguimiento;
    }

    public void setId_estado_seguimiento(String id_estado_seguimiento) {
        this.id_estado_seguimiento = id_estado_seguimiento;
    }

    public String getCod_orden_transporte() {
        return cod_orden_transporte;
    }

    public void setCod_orden_transporte(String cod_orden_transporte) {
        this.cod_orden_transporte = cod_orden_transporte;
    }
}
