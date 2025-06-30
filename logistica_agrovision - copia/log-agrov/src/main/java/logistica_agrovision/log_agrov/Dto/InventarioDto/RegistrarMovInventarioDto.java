package logistica_agrovision.log_agrov.Dto.InventarioDto;



public class RegistrarMovInventarioDto {
    
    private String tipoMovimiento;
    private String motivo;
    private int cantidad;
    private int idLote;
    private int idEmpleado;
    private String origen;
    private String destino;

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getIdLote() {
        return idLote;
    }
    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }
    public int getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
}
