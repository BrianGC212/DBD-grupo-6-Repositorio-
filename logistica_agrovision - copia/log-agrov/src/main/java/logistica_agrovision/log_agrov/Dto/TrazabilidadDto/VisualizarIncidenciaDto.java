package logistica_agrovision.log_agrov.Dto.TrazabilidadDto;

import java.time.LocalTime;
import java.util.Date;

public class VisualizarIncidenciaDto {
    private String cod;
    private String proceso;
    private Date fechaActualizada;
    private LocalTime horaActualizada;
    private String estado;

    public VisualizarIncidenciaDto(String cod, String proceso, Date fechaActualizada, LocalTime horaActualizada, String estado) {
        this.cod = cod;
        this.proceso = proceso;
        this.fechaActualizada = fechaActualizada;
        this.horaActualizada = horaActualizada;
        this.estado = estado;
    }

    // Getters

    public String getCod() {
        return cod;
    }

    public String getProceso() {
        return proceso;
    }

    public Date getFechaActualizada() {
        return fechaActualizada;
    }

    public LocalTime getHoraActualizada() {
        return horaActualizada;
    }

    public String getEstado() {
        return estado;
    }

    // Setters

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public void setFechaActualizada(Date fechaActualizada) {
        this.fechaActualizada = fechaActualizada;
    }

    public void setHoraActualizada(LocalTime horaActualizada) {
        this.horaActualizada = horaActualizada;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
