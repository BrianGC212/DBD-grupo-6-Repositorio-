package logistica_agrovision.log_agrov.Dto.RecepcionDto;

public class RegistroRecepcionDto {
    private int idLote;
    private double cantidadRecibida;
    private String observaciones;

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public double getCantidadRecibida() {
        return cantidadRecibida;
    }

    public void setCantidadRecibida(double cantidadRecibida) {
        this.cantidadRecibida = cantidadRecibida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
