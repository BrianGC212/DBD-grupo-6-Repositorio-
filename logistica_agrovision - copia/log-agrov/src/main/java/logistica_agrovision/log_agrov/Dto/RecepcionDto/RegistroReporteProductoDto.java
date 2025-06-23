package logistica_agrovision.log_agrov.Dto.RecepcionDto;

public class RegistroReporteProductoDto {
    private String especificacionNoCumplida;
    private String accionesATomar;
    private Integer idControlDeCalidad;

    // Getters y Setters
    public String getEspecificacionNoCumplida() {
        return especificacionNoCumplida;
    }

    public void setEspecificacionNoCumplida(String especificacionNoCumplida) {
        this.especificacionNoCumplida = especificacionNoCumplida;
    }

    public String getAccionesATomar() {
        return accionesATomar;
    }

    public void setAccionesATomar(String accionesATomar) {
        this.accionesATomar = accionesATomar;
    }

    public Integer getIdControlDeCalidad() {
        return idControlDeCalidad;
    }

    public void setIdControlDeCalidad(Integer idControlDeCalidad) {
        this.idControlDeCalidad = idControlDeCalidad;
    }
}
