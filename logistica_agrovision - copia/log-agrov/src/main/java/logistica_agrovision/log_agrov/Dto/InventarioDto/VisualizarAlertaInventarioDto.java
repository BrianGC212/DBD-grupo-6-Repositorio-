package logistica_agrovision.log_agrov.Dto.InventarioDto;

import java.time.LocalDateTime;

public class VisualizarAlertaInventarioDto {
    
    private String codAlertaInventario;
    private String estadoAlerta;
    private String tipoAlerta;
    private String severidad;
    private String descripcion;
    private LocalDateTime fechaHoraAlerta;
    private LocalDateTime fechaHoraSolucion;
    private String codLote;
    private int idEmpleado;

    public String getCodAlertaInventario() {
        return codAlertaInventario;
    }
    public void setCodAlertaInventario(String codAlertaInventario) {
        this.codAlertaInventario = codAlertaInventario;
    }
    public String getEstadoAlerta() {
        return estadoAlerta;
    }
    public void setEstadoAlerta(String estadoAlerta) {
        this.estadoAlerta = estadoAlerta;
    }
    public String getTipoAlerta() {
        return tipoAlerta;
    }
    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }
    public String getSeveridad() {
        return severidad;
    }
    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDateTime getFechaHoraAlerta() {
        return fechaHoraAlerta;
    }
    public void setFechaHoraAlerta(LocalDateTime fechaHoraAlerta) {
        this.fechaHoraAlerta = fechaHoraAlerta;
    }
    public LocalDateTime getFechaHoraSolucion() {
        return fechaHoraSolucion;
    }
    public void setFechaHoraSolucion(LocalDateTime fechaHoraSolucion) {
        this.fechaHoraSolucion = fechaHoraSolucion;
    }
    public String getCodLote() {
        return codLote;
    }
    public void setCodLote(String codLote) {
        this.codLote = codLote;
    }
    public int getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

}
