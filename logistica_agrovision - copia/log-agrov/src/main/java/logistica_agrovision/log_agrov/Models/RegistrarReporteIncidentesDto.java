package logistica_agrovision.log_agrov.Dto.TransporteDto;

public class RegistrarReporteIncidentesDto {
    private String id_estado_reporte; //ID REPORTE (P Y R)
    private String descripcion;
    private String id_tipo_incidente; // 1 Producto dañado,  2Retraso del producto  3Productos incompletos 4 OTROS
    private String id_cliente;
    private String nombre_realiza;
    private String dni_realiza;
    private String cod_guia_remision;
    private String cod_empleado;

    public String getId_estado_reporte() {
        return id_estado_reporte;
    }

    public void setId_estado_reporte(String id_estado_reporte) {
        this.id_estado_reporte = id_estado_reporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_tipo_incidente() {
        return id_tipo_incidente;
    }

    public void setId_tipo_incidente(String id_tipo_incidente) {
        this.id_tipo_incidente = id_tipo_incidente;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_realiza() {
        return nombre_realiza;
    }

    public void setNombre_realiza(String nombre_realiza) {
        this.nombre_realiza = nombre_realiza;
    }

    public String getDni_realiza() {
        return dni_realiza;
    }

    public void setDni_realiza(String dni_realiza) {
        this.dni_realiza = dni_realiza;
    }

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
}
