package logistica_agrovision.log_agrov.Dto.EquiposDto;

public class VisualizarProgramacionesDto {

    private String codigoPlanificacion;
    private String equipo;
    private String area;
    private String responsable;
    private String fechaDeInicio;
    private String fechaDeFin;
    private String descripcion;
    public String getCodigoPlanificacion() {
        return codigoPlanificacion;
    }
    public void setCodigoPlanificacion(String codigoPlanificacion) {
        this.codigoPlanificacion = codigoPlanificacion;
    }
    public String getEquipo() {
        return equipo;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getResponsable() {
        return responsable;
    }
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    public String getFechaDeInicio() {
        return fechaDeInicio;
    }
    public void setFechaDeInicio(String fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }
    public String getFechaDeFin() {
        return fechaDeFin;
    }
    public void setFechaDeFin(String fechaDeFin) {
        this.fechaDeFin = fechaDeFin;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}