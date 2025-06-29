package logistica_agrovision.log_agrov.Dto.TrazabilidadDto;

import java.time.LocalTime;
import java.util.Date;

public class RegistrarIncidenciaDto {
    private String codIncidencias;
    private String causa;
    private String tipoIncidencia;
    private String estado;
    private Date fechaRegistrada;
    private LocalTime hora;
    private String observaciones;
    private String evidencias;
    private Date fechaResolucion;
    private Integer idEmpleado;
    private Integer idProcesos;

    // Getters

    public String getCodIncidencias() {
        return codIncidencias;
    }

    public String getCausa() {
        return causa;
    }

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaRegistrada() {
        return fechaRegistrada;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getEvidencias() {
        return evidencias;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public Integer getIdProcesos() {
        return idProcesos;
    }

    // Setters

    public void setCodIncidencias(String codIncidencias) {
        this.codIncidencias = codIncidencias;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public void setTipoIncidencia(String tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaRegistrada(Date fechaRegistrada) {
        this.fechaRegistrada = fechaRegistrada;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setEvidencias(String evidencias) {
        this.evidencias = evidencias;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setIdProcesos(Integer idProcesos) {
        this.idProcesos = idProcesos;
    }
}