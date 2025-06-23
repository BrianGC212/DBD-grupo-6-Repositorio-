package logistica_agrovision.log_agrov.Dto.RecepcionDto;

public class EstadisticaPorProductoDto {
    private String nombreProducto;
    private int totalRecepciones;
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public int getTotalRecepciones() {
        return totalRecepciones;
    }
    public void setTotalRecepciones(int totalRecepciones) {
        this.totalRecepciones = totalRecepciones;
    }

    // Getters y Setters
}
