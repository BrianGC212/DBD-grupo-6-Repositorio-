package logistica_agrovision.log_agrov.Dto.TransporteDto;

import java.util.ArrayList;
import java.util.List;

public class RegistrarOrdenTransporteDto {
    private String fecha_salida;
    private String hora_salida;
    private String cod_empleado;
    private List<String> guiasRemision = new ArrayList<>(); // O LinkedList<>

    public void agregarDatos(String s){
        guiasRemision.add(s);
    }

    public List<String> getGuiasRemision() {
        return guiasRemision;
    }
    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(String cod_empleado) {
        this.cod_empleado = cod_empleado;
    }
}
