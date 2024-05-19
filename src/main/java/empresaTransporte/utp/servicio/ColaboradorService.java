package empresaTransporte.utp.servicio;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.util.RespuestaControlador;
import empresaTransporte.utp.util.dto.ColaboradorBusquedaRequestDTO;
import empresaTransporte.utp.util.dto.ColaboradorBusquedaResponseDTO;

import java.util.List;
import java.util.Map;

public interface ColaboradorService {

    List<Colaborador> listarColaboradoresActivos();

    RespuestaControlador guardar (Colaborador colaborador);

    RespuestaControlador actualizar (Colaborador colaborador);

    Colaborador findById(Long idColaborador);

    RespuestaControlador eliminar (Long id);

    ColaboradorBusquedaResponseDTO busquedaPaginada(ColaboradorBusquedaRequestDTO dto);

    Colaborador getById(Long colaboradorId);

    RespuestaControlador cesarColaborador(Long colaboradorId);

    RespuestaControlador anularColaborador(Long colaboradorId);

}
