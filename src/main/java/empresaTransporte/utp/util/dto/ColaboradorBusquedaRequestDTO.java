package empresaTransporte.utp.util.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColaboradorBusquedaRequestDTO {

    private String numeroDocumento;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Long areaId;
    private Long cargoId;
    private Long tipoDocumentoId;
    private Long estadoEmpleadoId;
    private Long grupoLaboralId;
    private Integer max;
    private Integer limite;

}
