package logistica_agrovision.log_agrov.Dto.TransporteDto;

public class RegistrarGuiaDto {
    private String fecha_de_traslado;
    private String placa_vehiculo;
    private String cod_empleado;
    private String cod_pedido;
    private String cod_transportista;

    public String getCod_transportista() {
        return cod_transportista;
    }

    public void setCod_transportista(String cod_transportista) {
        this.cod_transportista = cod_transportista;
    }

    public String getFecha_de_traslado() {
        return fecha_de_traslado;
    }

    public void setFecha_de_traslado(String fecha_de_traslado) {
        this.fecha_de_traslado = fecha_de_traslado;
    }

    public String getPlaca_vehiculo() {
        return placa_vehiculo;
    }

    public void setPlaca_vehiculo(String placa_vehiculo) {
        this.placa_vehiculo = placa_vehiculo;
    }

    public String getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(String cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public String getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(String cod_pedido) {
        this.cod_pedido = cod_pedido;
    }
}
