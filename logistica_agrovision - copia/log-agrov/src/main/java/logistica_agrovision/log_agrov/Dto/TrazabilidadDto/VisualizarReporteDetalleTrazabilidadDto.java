package logistica_agrovision.log_agrov.Dto.TrazabilidadDto;

import java.time.LocalTime;
import java.util.Date;

public class VisualizarReporteDetalleTrazabilidadDto {

    private String codigo;
    private String proceso;
    private Date fechaActualizada;
    private LocalTime horaActualizada;
    private String estado;
    private String firmas;
    private String anexos;

    public VisualizarReporteDetalleTrazabilidadDto(
        String codigo,
        String proceso,
        Date fechaActualizada,
        LocalTime horaActualizada,
        String estado,
        String firmas,
        String anexos
    ) {
        this.codigo = codigo;
        this.proceso = proceso;
        this.fechaActualizada = fechaActualizada;
        this.horaActualizada = horaActualizada;
        this.estado = estado;
        this.firmas = firmas;
        this.anexos = anexos;
    }

    // Getters y setters

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

    public String getFirmas() {
        return firmas;
    }

    public void setFirmas(String firmas) {
        this.firmas = firmas;
    }

    public String getAnexos() {
        return anexos;
    }

    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }
}