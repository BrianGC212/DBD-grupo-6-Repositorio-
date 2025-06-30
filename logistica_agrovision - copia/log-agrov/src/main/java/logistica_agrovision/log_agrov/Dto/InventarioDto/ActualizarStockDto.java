package logistica_agrovision.log_agrov.Dto.InventarioDto;

public class ActualizarStockDto {
    
    private int idLote;
    private Float cantidadReal;

    public int getIdLote() {
        return idLote;
    }
    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }
    public Float getCantidadReal() {
        return cantidadReal;
    }
    public void setCantidadReal(Float cantidadReal) {
        this.cantidadReal = cantidadReal;
    }

}
