package logistica_agrovision.log_agrov.Dto.TransporteDto;
import java.util.ArrayList;
import java.util.List;

public class RegistrarGuiaXOrdenDto {
    private List<String> guiasRemision = new ArrayList<>(); // O LinkedList<>

    public void agregarDatos(String s){
        guiasRemision.add(s);
    }

    public List<String> getGuiasRemision() {
        return guiasRemision;
    }
}
