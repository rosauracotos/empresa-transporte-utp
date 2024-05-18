package empresaTransporte.utp.util.dto;

import empresaTransporte.utp.entidad.master.Turno;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TurnosLaboralRequestDTO {

    private List<Long> colaboradoresIds;
    private Turno turno;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

}
