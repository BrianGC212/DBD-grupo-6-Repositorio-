package logistica_agrovision.log_agrov.Dto.TrazabilidadDto;

import java.time.LocalTime;
import java.util.Date;

public class VisualizarReporteTrazabilidadDto {

    private String codigo;
    private String proceso;
    private Date fechaActualizada;
    private LocalTime horaActualizada;
    private String estado;

    public VisualizarReporteTrazabilidadDto(String codigo, String proceso, Date fechaActualizada, LocalTime horaActualizada, String estado) {
        this.codigo = codigo;
        this.proceso = proceso;
        this.fechaActualizada = fechaActualizada;
        this.horaActualizada = horaActualizada;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
}
