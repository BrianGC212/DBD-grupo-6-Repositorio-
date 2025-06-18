package logistica_agrovision.log_agrov.Dto.RecepcionDto;

public class FormularioReporteProductoDto {
    private String codLote;
    private String nombreProducto;
    private Integer idControlDeCalidad;

    // Getters y Setters
    public String getCodLote() {
        return codLote;
    }

    public void setCodLote(String codLote) {
        this.codLote = codLote;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getIdControlDeCalidad() {
        return idControlDeCalidad;
    }

    public void setIdControlDeCalidad(Integer idControlDeCalidad) {
        this.idControlDeCalidad = idControlDeCalidad;
    }
}
