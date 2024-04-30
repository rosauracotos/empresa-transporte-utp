package empresaTransporte.utp.servicio;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.util.RespuestaControlador;

import java.util.List;

public interface ColaboradorService {

    List<Colaborador> listarColaboradores();

    public RespuestaControlador guardar (Colaborador colaborador);

    public RespuestaControlador actualizar (Colaborador colaborador);

    public RespuestaControlador eliminar (Long id);

}
