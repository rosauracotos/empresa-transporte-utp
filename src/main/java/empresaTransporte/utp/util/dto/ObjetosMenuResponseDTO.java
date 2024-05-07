package empresaTransporte.utp.util.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ObjetosMenuResponseDTO {

    private Long id;
    private String nombre;
    private List<ObjetosMenuResponseDTO> detalle;

}
