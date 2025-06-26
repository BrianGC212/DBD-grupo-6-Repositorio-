package logistica_agrovision.log_agrov.Dto.EquiposDto;

public class HistorialDto {

    private String codigoReporte;
    private String equipo;
    private String estado;
    private String cambioArea;
    private String fechaInicio;
    private String fechaFin;
    private String maquinaSustituta;
    private String detalle;

    // Getters and Setters
    public String getCodigoReporte() {
        return codigoReporte;
    }

    public void setCodigoReporte(String codigoReporte) {
        this.codigoReporte = codigoReporte;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCambioArea() {
        return cambioArea;
    }

    public void setCambioArea(String cambioArea) {
        this.cambioArea = cambioArea;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMaquinaSustituta() {
        return maquinaSustituta;
    }

    public void setMaquinaSustituta(String maquinaSustituta) {
        this.maquinaSustituta = maquinaSustituta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
