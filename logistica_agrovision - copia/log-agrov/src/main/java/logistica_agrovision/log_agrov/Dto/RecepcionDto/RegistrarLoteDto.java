package logistica_agrovision.log_agrov.Dto.RecepcionDto;


public class RegistrarLoteDto {

    private int idTipoLote;
    private double cantidadTotal;
    private String unidad;
    private String fechaVencimiento;
    private String fechaProduccion;
    private String idProducto;

    public int getIdTipoLote() {
        return idTipoLote;
    }

    public void setIdTipoLote(int idTipoLote) {
        this.idTipoLote = idTipoLote;
    }

    public double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(String fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
}
