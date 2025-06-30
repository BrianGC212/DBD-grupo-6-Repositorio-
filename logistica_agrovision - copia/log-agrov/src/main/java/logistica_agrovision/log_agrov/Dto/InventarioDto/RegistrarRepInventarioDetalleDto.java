package logistica_agrovision.log_agrov.Dto.InventarioDto;

public class RegistrarRepInventarioDetalleDto {
    
    private int idReporteInventario;
    private int idLote;
    private Float cantidadEsperada;
    private Float cantidadReal;
    private String observacion;

    public int getIdReporteInventario() {
        return idReporteInventario;
    }
    public void setIdReporteInventario(int idReporteInventario) {
        this.idReporteInventario = idReporteInventario;
    }
    public int getIdLote() {
        return idLote;
    }
    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }
    public Float getCantidadEsperada() {
        return cantidadEsperada;
    }
    public void setCantidadEsperada(Float cantidadEsperada) {
        this.cantidadEsperada = cantidadEsperada;
    }
    public Float getCantidadReal() {
        return cantidadReal;
    }
    public void setCantidadReal(Float cantidadReal) {
        this.cantidadReal = cantidadReal;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
