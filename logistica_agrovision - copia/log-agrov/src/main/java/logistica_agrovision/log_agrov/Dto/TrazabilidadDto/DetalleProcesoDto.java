package logistica_agrovision.log_agrov.Dto.TrazabilidadDto;

import java.time.LocalTime;
import java.util.Date;

/**
 * Data Transfer Object (DTO) para representar el detalle de un proceso.
 */
public class DetalleProcesoDto {

    private String codigo;
    private String supervisor;
    private String codigoEmpleado;
    private String tipoEmpleado;
    private LocalTime hora;
    private Date fecha;
    private String observaciones;

    /**
     * Constructor para inicializar todos los campos del DTO de detalle de proceso.
     *
     * @param codigo         El código único del proceso.
     * @param supervisor     El nombre del supervisor a cargo.
     * @param codigoEmpleado El código del empleado asociado.
     * @param tipoEmpleado   El tipo de empleado (e.g., "Operario", "Técnico").
     * @param hora           La hora en que se registró el detalle.
     * @param fecha          La fecha en que se registró el detalle.
     * @param observaciones  Cualquier observación adicional.
     */
    public DetalleProcesoDto(String codigo, String supervisor, String codigoEmpleado,
                             String tipoEmpleado, LocalTime hora, Date fecha, String observaciones) {
        this.codigo = codigo;
        this.supervisor = supervisor;
        this.codigoEmpleado = codigoEmpleado;
        this.tipoEmpleado = tipoEmpleado;
        this.hora = hora;
        this.fecha = fecha;
        this.observaciones = observaciones;
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
     * Obtiene el nombre del supervisor.
     * @return El nombre del supervisor.
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * Establece el nombre del supervisor.
     * @param supervisor El nuevo nombre del supervisor.
     */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * Obtiene el código del empleado.
     * @return El código del empleado.
     */
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    /**
     * Establece el código del empleado.
     * @param codigoEmpleado El nuevo código del empleado.
     */
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    /**
     * Obtiene el tipo de empleado.
     * @return El tipo de empleado.
     */
    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    /**
     * Establece el tipo de empleado.
     * @param tipoEmpleado El nuevo tipo de empleado.
     */
    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    /**
     * Obtiene la hora del registro.
     * @return La hora del registro.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora del registro.
     * @param hora La nueva hora a establecer.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Obtiene la fecha del registro.
     * @return La fecha del registro.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del registro.
     * @param fecha La nueva fecha a establecer.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene las observaciones.
     * @return Las observaciones del registro.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece las observaciones.
     * @param observaciones Las nuevas observaciones a establecer.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}