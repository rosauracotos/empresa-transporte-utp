package empresaTransporte.utp.servicio;

import empresaTransporte.utp.entidad.colaborador.ColaboradorHorario;
import empresaTransporte.utp.util.RespuestaControlador;
import empresaTransporte.utp.util.dto.TurnosLaboralRequestDTO;

import java.util.List;

public interface ColabHorarioService {

    List<ColaboradorHorario> listarColabHorario();

    public RespuestaControlador guardar (ColaboradorHorario colaboradorHorario);

    RespuestaControlador guardarTurnos(TurnosLaboralRequestDTO turnosLaboralRequestDTO);

    public RespuestaControlador actualizar (ColaboradorHorario colaboradorHorario);

    public abstract ColaboradorHorario findById(Integer idColabHorario);
}
