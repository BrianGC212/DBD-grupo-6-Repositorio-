package logistica_agrovision.log_agrov.Dto.TransporteDto;

public class RegistrarInformeEntregaDto {
    private String nombre_receptor;
    private String dni_receptor;
    private String observacion;
    private String cod_guia_remision;

    public String getNombre_receptor() {
        return nombre_receptor;
    }

    public void setNombre_receptor(String nombre_receptor) {
        this.nombre_receptor = nombre_receptor;
    }

    public String getDni_receptor() {
        return dni_receptor;
    }

    public void setDni_receptor(String dni_receptor) {
        this.dni_receptor = dni_receptor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getCod_guia_remision() {
        return cod_guia_remision;
    }

    public void setCod_guia_remision(String cod_guia_remision) {
        this.cod_guia_remision = cod_guia_remision;
    }
}
