package logistica_agrovision.log_agrov.Dto.TransporteDto;

public class VisualizarOrdenXGuiaPorOrdenDto {
    private String cod_orden_transporte;
    private String cod_guia_remision;

    public String getCod_orden_transporte() {
        return cod_orden_transporte;
    }

    public void setCod_orden_transporte(String cod_orden_transporte) {
        this.cod_orden_transporte = cod_orden_transporte;
    }

    public String getCod_guia_remision() {
        return cod_guia_remision;
    }

    public void setCod_guia_remision(String cod_guia_remision) {
        this.cod_guia_remision = cod_guia_remision;
    }
}
