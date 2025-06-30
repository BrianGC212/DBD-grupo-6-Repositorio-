package logistica_agrovision.log_agrov.Dto.InventarioDto;

import java.time.LocalDateTime;

public class VisualizarReporteInventarioDto {
    
    private String codReporteInventario;
    private LocalDateTime fechaInventario;
    private int idDetalle;
    private int idLote;
    private Float cantidadEsperada;
    private Float cantidadReal;
    private Float diferencia;
    private String observacion;

    public String getCodReporteInventario() {
        return codReporteInventario;
    }
    public void setCodReporteInventario(String codReporteInventario) {
        this.codReporteInventario = codReporteInventario;
    }
    public LocalDateTime getFechaInventario() {
        return fechaInventario;
    }
    public void setFechaInventario(LocalDateTime fechaInventario) {
        this.fechaInventario = fechaInventario;
    }
    public int getIdDetalle() {
        return idDetalle;
    }
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
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
    public Float getDiferencia() {
        return diferencia;
    }
    public void setDiferencia(Float diferencia) {
        this.diferencia = diferencia;
    }

}
