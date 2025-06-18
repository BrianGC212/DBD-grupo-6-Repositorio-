package logistica_agrovision.log_agrov.Dto.EquiposDto;

public class RegistrarEquipoDto {
    private String nombreEquipo;   
    private String tipoMaquinaId;    
    private String estadoMaquinaId;  
    private String detalle;   
    private int id_empleado;    

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

   
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getTipoMaquinaId() {
        return tipoMaquinaId;
    }

    public void setTipoMaquinaId(String tipoMaquinaId) {
        this.tipoMaquinaId = tipoMaquinaId;
    }

    public String getEstadoMaquinaId() {
        return estadoMaquinaId;
    }

    public void setEstadoMaquinaId(String estadoMaquinaId) {
        this.estadoMaquinaId = estadoMaquinaId;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
