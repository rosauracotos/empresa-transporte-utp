package empresaTransporte.utp.util.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoginResponseDTO {

    private Long usuarioIdLogueado;
    private String nombreUsuarioLogueado;
    private List<ObjetosMenuResponseDTO> detalle;

}
