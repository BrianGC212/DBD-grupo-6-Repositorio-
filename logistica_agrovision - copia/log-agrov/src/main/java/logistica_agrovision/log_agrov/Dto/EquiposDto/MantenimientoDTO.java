package logistica_agrovision.log_agrov.Dto.EquiposDto;

import java.util.Date;

public class MantenimientoDTO {

    private String codigoMantenimiento;  
    private Date fechaRegistro;
    private Date fechaInicio;  
    private Date fechaFin;  
    private String empresaEncargada;  
    private int codigoEquipo; 
    private String idEstadoEquipo;  
    private String idEstadoMantenimiento;  
    private int idEmpleadoRegistra;  
    private int idEmpleadoSolicita; 
       private Integer codigoMaquinaSustituta; 
    public Integer getCodigoMaquinaSustituta() {
        return codigoMaquinaSustituta;
    }
       public void setCodigoMaquinaSustituta(Integer codigoMaquinaSustituta) {
           this.codigoMaquinaSustituta = codigoMaquinaSustituta;
       }

    public String getCodigoMantenimiento()
     {
        return codigoMantenimiento;
    }
    public void setCodigoMantenimiento(String codigoMantenimiento) {
        this.codigoMantenimiento = codigoMantenimiento;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getEmpresaEncargada() {
        return empresaEncargada;
    }
    public void setEmpresaEncargada(String empresaEncargada) {
        this.empresaEncargada = empresaEncargada;
    }
    public int getCodigoEquipo() {
        return codigoEquipo;
    }
    public void setCodigoEquipo(int codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }
    public String getIdEstadoEquipo() {
        return idEstadoEquipo;
    }
    public void setIdEstadoEquipo(String idEstadoEquipo) {
        this.idEstadoEquipo = idEstadoEquipo;
    }
    public String getIdEstadoMantenimiento() {
        return idEstadoMantenimiento;
    }
    public void setIdEstadoMantenimiento(String idEstadoMantenimiento) {
        this.idEstadoMantenimiento = idEstadoMantenimiento;
    }
    public int getIdEmpleadoRegistra() {
        return idEmpleadoRegistra;
    }
    public void setIdEmpleadoRegistra(int idEmpleadoRegistra) {
        this.idEmpleadoRegistra = idEmpleadoRegistra;
    }
    public int getIdEmpleadoSolicita() {
        return idEmpleadoSolicita;
    }
    public void setIdEmpleadoSolicita(int idEmpleadoSolicita) {
        this.idEmpleadoSolicita = idEmpleadoSolicita;
    }

 
}
