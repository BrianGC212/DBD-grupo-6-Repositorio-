package logistica_agrovision.log_agrov.Dto.EquiposDto;

import java.util.Date;
public class EquipoDTO {

    private String codigoEquipo;
    private String nombreEquipo;
    private String tipoMaquina;
    private String estadoMaquina;
    private Date fechaRegistro;
    private Date fechaSalida;
    private String detalle;

    public EquipoDTO(String codigoEquipo, String nombreEquipo, String tipoMaquina, 
                     String estadoMaquina, Date fechaRegistro, Date fechaSalida, String detalle) {
        this.codigoEquipo = codigoEquipo;
        this.nombreEquipo = nombreEquipo;
        this.tipoMaquina = tipoMaquina;
        this.estadoMaquina = estadoMaquina;
        this.fechaRegistro = fechaRegistro;
        this.fechaSalida = fechaSalida;
        this.detalle = detalle;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getTipoMaquina() {
        return tipoMaquina;
    }

    public void setTipoMaquina(String tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    public String getEstadoMaquina() {
        return estadoMaquina;
    }

    public void setEstadoMaquina(String estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
