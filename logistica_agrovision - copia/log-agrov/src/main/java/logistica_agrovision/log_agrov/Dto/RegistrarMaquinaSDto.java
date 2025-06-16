package logistica_agrovision.log_agrov.Dto;

public class RegistrarMaquinaSDto {
    
    private String codEquipo; // Código del equipo a sustituir
    private String estadoMaquina; // Estado de la máquina sustituta
    private String nombreMaquina; // Nombre de la máquina sustituta
    private int idEmpleado; // ID del empleado que registra la máquina sustituta

    // Getters y setters
    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getEstadoMaquina() {
        return estadoMaquina;
    }

    public void setEstadoMaquina(String estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }

    public String getNombreMaquina() {
        return nombreMaquina;
    }

    public void setNombreMaquina(String nombreMaquina) {
        this.nombreMaquina = nombreMaquina;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
