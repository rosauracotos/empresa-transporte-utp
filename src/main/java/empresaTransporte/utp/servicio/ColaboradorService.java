package empresaTransporte.utp.servicio;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.util.RespuestaControlador;

import java.util.List;

public interface ColaboradorService {

    List<Colaborador> listarColaboradoresActivos();

    RespuestaControlador guardar (Colaborador colaborador);

    RespuestaControlador actualizar (Colaborador colaborador);

    Colaborador findById(Long idColaborador);

    RespuestaControlador eliminar (Long id);

}
