package logistica_agrovision.log_agrov.Dto.RecepcionDto;

public class VisualizarLotesDto {

    private String codLote;
    private String nombreProducto;
    private String tipoDelLote;
    private String fechaProduccion;
    private Double cantidad;
    private String unidad;
    private String estadoLote;

    public String getCodLote() {
        return codLote;
    }

    public void setCodLote(String codLote) {
        this.codLote = codLote;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getTipoDelLote() {
        return tipoDelLote;
    }

    public void setTipoDelLote(String tipoDelLote) {
        this.tipoDelLote = tipoDelLote;
    }

    public String getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(String fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
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

    public String getEstadoLote() {
        return estadoLote;
    }

    public void setEstadoLote(String estadoLote) {
        this.estadoLote = estadoLote;
    }
}
