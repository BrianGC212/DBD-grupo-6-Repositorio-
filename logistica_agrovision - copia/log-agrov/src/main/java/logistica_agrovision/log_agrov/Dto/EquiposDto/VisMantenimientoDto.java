package logistica_agrovision.log_agrov.Dto.EquiposDto;

public class VisMantenimientoDto {

    private String codigoMantenimiento;
    private String equipo;
    private String empresaEncargada;
    private String tipoServicio;
    private String fechaEntregaAEmpresa;
    private String fechaEntregaDeVuelta;
    private String maquinaSustituta;
    private String estadoEquipo;

    // Getters and Setters
    public String getCodigoMantenimiento() {
        return codigoMantenimiento;
    }

    public void setCodigoMantenimiento(String codigoMantenimiento) {
        this.codigoMantenimiento = codigoMantenimiento;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getEmpresaEncargada() {
        return empresaEncargada;
    }

    public void setEmpresaEncargada(String empresaEncargada) {
        this.empresaEncargada = empresaEncargada;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getFechaEntregaAEmpresa() {
        return fechaEntregaAEmpresa;
    }

    public void setFechaEntregaAEmpresa(String fechaEntregaAEmpresa) {
        this.fechaEntregaAEmpresa = fechaEntregaAEmpresa;
    }

    public String getFechaEntregaDeVuelta() {
        return fechaEntregaDeVuelta;
    }

    public void setFechaEntregaDeVuelta(String fechaEntregaDeVuelta) {
        this.fechaEntregaDeVuelta = fechaEntregaDeVuelta;
    }

    public String getMaquinaSustituta() {
        return maquinaSustituta;
    }

    public void setMaquinaSustituta(String maquinaSustituta) {
        this.maquinaSustituta = maquinaSustituta;
    }

    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(String estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }
}
