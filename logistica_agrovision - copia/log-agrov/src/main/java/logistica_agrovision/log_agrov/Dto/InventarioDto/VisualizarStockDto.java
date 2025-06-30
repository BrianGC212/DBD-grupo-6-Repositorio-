package logistica_agrovision.log_agrov.Dto.InventarioDto;

public class VisualizarStockDto {
    
    private String nombreProducto;
    private int stockDisponible;
    private int stockMinimo;
    private int stockMaximo;

    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public int getStockDisponible() {
        return stockDisponible;
    }
    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }
    public int getStockMinimo() {
        return stockMinimo;
    }
    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    public int getStockMaximo() {
        return stockMaximo;
    }
    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }
}
