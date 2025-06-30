package logistica_agrovision.log_agrov.Dto.InventarioDto;

import java.time.LocalDateTime;


public class VisualizarMovInventarioDto {
    
    private String codMovimientoInventario;
    private LocalDateTime fechaMovimiento;
    private String codLote;
    private String destino;
    private String tipoMovimientoDescripcion;
    private String codEmpleado;

    public String getCodMovimientoInventario() {
        return codMovimientoInventario;
    }

    public void setCodMovimientoInventario(String codMovimientoInventario) {
        this.codMovimientoInventario = codMovimientoInventario;
    }

    public LocalDateTime getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDateTime fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getCodLote() {
        return codLote;
    }

    public void setCodLote(String codLote) {
        this.codLote = codLote;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoMovimientoDescripcion() {
        return tipoMovimientoDescripcion;
    }

    public void setTipoMovimientoDescripcion(String tipoMovimientoDescripcion) {
        this.tipoMovimientoDescripcion = tipoMovimientoDescripcion;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

}
