package logistica_agrovision.log_agrov.Dto.RecepcionDto;

public class VisualizacionControlCalidadDto {
    private String codControlCalidad;
    private String nombreProducto;
    private String descripcionLote;
    private Double cantidadTotal;
    private String unidad;
    private String estadoControlCalidad;

    // Getters y Setters

    public String getCodControlCalidad() {
        return codControlCalidad;
    }

    public void setCodControlCalidad(String codControlCalidad) {
        this.codControlCalidad = codControlCalidad;
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

    public Double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getEstadoControlCalidad() {
        return estadoControlCalidad;
    }

    public void setEstadoControlCalidad(String estadoControlCalidad) {
        this.estadoControlCalidad = estadoControlCalidad;
    }
}
