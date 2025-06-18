// EstadisticaPorMesDto.java
package logistica_agrovision.log_agrov.Dto.RecepcionDto;

import java.time.LocalDate;

public class EstadisticaPorMesDto {
    private LocalDate mes;
    private int totalRecepciones;
    public LocalDate getMes() {
        return mes;
    }
    public void setMes(LocalDate mes) {
        this.mes = mes;
    }
    public int getTotalRecepciones() {
        return totalRecepciones;
    }
    public void setTotalRecepciones(int totalRecepciones) {
        this.totalRecepciones = totalRecepciones;
    }

}
