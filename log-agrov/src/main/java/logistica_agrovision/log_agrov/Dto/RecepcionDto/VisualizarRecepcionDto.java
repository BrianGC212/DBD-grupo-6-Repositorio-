package logistica_agrovision.log_agrov.Dto.RecepcionDto;

public class VisualizarRecepcionDto {

    private String codRecepcion;
    private String nombreProducto;
    private String descripcionLote;
    private Double cantidad;
    private String unidad;
    private String estadoRecepcion;

    public String getCodRecepcion() {
        return codRecepcion;
    }

    public void setCodRecepcion(String codRecepcion) {
        this.codRecepcion = codRecepcion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionLote() {
        return descripcionLote;
    }

    public void setDescripcionLote(String descripcionLote) {
        this.descripcionLote = descripcionLote;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getEstadoRecepcion() {
        return estadoRecepcion;
    }

    public void setEstadoRecepcion(String estadoRecepcion) {
        this.estadoRecepcion = estadoRecepcion;
    }
}