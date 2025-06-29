package logistica_agrovision.log_agrov.Dto.TrazabilidadDto;

import java.time.LocalTime;
import java.util.Date;

/**
 * Data Transfer Object (DTO) para visualizar la información de un proceso.
 */
public class VisualizarProcesoDto {

    private String codigo;
    private String proceso;
    private Date fechaActualizada;
    private LocalTime horaActualizada;
    private String estado;

    /**
     * Constructor para inicializar todos los campos del DTO.
     *
     * @param codigo           El código único del proceso.
     * @param proceso          El nombre o descripción del proceso.
     * @param fechaActualizada La fecha de la última actualización.
     * @param horaActualizada  La hora de la última actualización.
     * @param estado           El estado actual del proceso.
     */
    public VisualizarProcesoDto(String codigo, String proceso, Date fechaActualizada, LocalTime horaActualizada, String estado) {
        this.codigo = codigo;
        this.proceso = proceso;
        this.fechaActualizada = fechaActualizada;
        this.horaActualizada = horaActualizada;
        this.estado = estado;
    }

    // --- Getters y Setters ---

    /**
     * Obtiene el código del proceso.
     * @return El código del proceso.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del proceso.
     * @param codigo El nuevo código a establecer.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el nombre del proceso.
     * @return El nombre del proceso.
     */
    public String getProceso() {
        return proceso;
    }

    /**
     * Establece el nombre del proceso.
     * @param proceso El nuevo nombre a establecer.
     */
    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    /**
     * Obtiene la fecha de la última actualización.
     * @return La fecha de actualización.
     */
    public Date getFechaActualizada() {
        return fechaActualizada;
    }

    /**
     * Establece la fecha de la última actualización.
     * @param fechaActualizada La nueva fecha de actualización.
     */
    public void setFechaActualizada(Date fechaActualizada) {
        this.fechaActualizada = fechaActualizada;
    }

    /**
     * Obtiene la hora de la última actualización.
     * @return La hora de actualización.
     */
    public LocalTime getHoraActualizada() {
        return horaActualizada;
    }

    /**
     * Establece la hora de la última actualización.
     * @param horaActualizada La nueva hora de actualización.
     */
    public void setHoraActualizada(LocalTime horaActualizada) {
        this.horaActualizada = horaActualizada;
    }

    /**
     * Obtiene el estado del proceso.
     * @return El estado del proceso.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del proceso.
     * @param estado El nuevo estado a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}