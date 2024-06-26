package empresaTransporte.utp.util.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ColaboradorBusquedaResponseDTO {

    private Integer totalRegistros;
    private Integer cantidadPorPagina;
    private Integer paginaActual;
    private List<Map<String,Object>> data;

}
