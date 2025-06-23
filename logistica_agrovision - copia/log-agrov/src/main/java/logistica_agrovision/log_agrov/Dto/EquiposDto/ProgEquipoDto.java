package logistica_agrovision.log_agrov.Dto.EquiposDto;

import java.time.LocalDateTime;

public class ProgEquipoDto {

    private Integer idEquipo;
    
    private LocalDateTime fechaInicio; 
   
    private LocalDateTime fechaFin;    
  
    private String descripcionTarea;
    
    private String idArea;
 
   
    private Integer idEmpleadoRegistra;
   
    private Integer idEmpleadoSolicita;



    public Integer getIdEquipo() {
        return idEquipo;
    }
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

      public LocalDateTime getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }
 public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Integer getIdEmpleadoSolicita() {
        return idEmpleadoSolicita;
    }
    public void setIdEmpleadoSolicita(Integer idEmpleadoSolicita) {
        this.idEmpleadoSolicita = idEmpleadoSolicita;
    }

public String getDescripcionTarea() {
        return descripcionTarea;
    }
    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }
   public String getIdArea() {
        return idArea;
    }
    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }
 public Integer getIdEmpleadoRegistra() {
        return idEmpleadoRegistra;
    }
    public void setIdEmpleadoRegistra(Integer idEmpleadoRegistra) {
        this.idEmpleadoRegistra = idEmpleadoRegistra;
    }



    }



