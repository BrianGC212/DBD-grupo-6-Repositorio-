package logistica_agrovision.log_agrov.Dto.RecepcionDto;

public class RegistroControlCalidadDto {
    private String idEstadoPaqueteRecepcion;
    private double temperaturaProducto;
    private String observacionesLote;
    private String observacionesEmpaque;
    private int idRecepcion;
    private int idEmpleado;

    public String getIdEstadoPaqueteRecepcion() {
        return idEstadoPaqueteRecepcion;
    }

    public void setIdEstadoPaqueteRecepcion(String idEstadoPaqueteRecepcion) {
        this.idEstadoPaqueteRecepcion = idEstadoPaqueteRecepcion;
    }

    public double getTemperaturaProducto() {
        return temperaturaProducto;
    }

    public void setTemperaturaProducto(double temperaturaProducto) {
        this.temperaturaProducto = temperaturaProducto;
    }

    public String getObservacionesLote() {
        return observacionesLote;
    }

    public void setObservacionesLote(String observacionesLote) {
        this.observacionesLote = observacionesLote;
    }

    public String getObservacionesEmpaque() {
        return observacionesEmpaque;
    }

    public void setObservacionesEmpaque(String observacionesEmpaque) {
        this.observacionesEmpaque = observacionesEmpaque;
    }

    public int getIdRecepcion() {
        return idRecepcion;
    }

    public void setIdRecepcion(int idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
