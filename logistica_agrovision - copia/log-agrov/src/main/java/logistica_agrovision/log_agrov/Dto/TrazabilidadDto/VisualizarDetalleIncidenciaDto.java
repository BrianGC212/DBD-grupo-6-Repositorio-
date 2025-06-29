package logistica_agrovision.log_agrov.Dto.TrazabilidadDto;

import java.time.LocalTime;
import java.util.Date;

public class VisualizarDetalleIncidenciaDto {

    private String cod;
    private String proceso;
    private Date fechaActualizada;
    private LocalTime horaActualizada;
    private String estado;
    private String evidencias;
    private String observaciones;
    private Date fechaResolucion;

    public VisualizarDetalleIncidenciaDto(String cod, String proceso, Date fechaActualizada, LocalTime horaActualizada,
                                          String estado, String evidencias, String observaciones, Date fechaResolucion) {
        this.cod = cod;
        this.proceso = proceso;
        this.fechaActualizada = fechaActualizada;
        this.horaActualizada = horaActualizada;
        this.estado = estado;
        this.evidencias = evidencias;
        this.observaciones = observaciones;
        this.fechaResolucion = fechaResolucion;
    }

    // Getters y Setters

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public Date getFechaActualizada() {
        return fechaActualizada;
    }

    public void setFechaActualizada(Date fechaActualizada) {
        this.fechaActualizada = fechaActualizada;
    }

    public LocalTime getHoraActualizada() {
        return horaActualizada;
    }

    public void setHoraActualizada(LocalTime horaActualizada) {
        this.horaActualizada = horaActualizada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEvidencias() {
        return evidencias;
    }

    public void setEvidencias(String evidencias) {
        this.evidencias = evidencias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }
}