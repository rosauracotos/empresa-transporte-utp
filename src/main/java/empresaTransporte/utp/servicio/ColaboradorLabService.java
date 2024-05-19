package empresaTransporte.utp.servicio;


import empresaTransporte.utp.entidad.colaborador.ColaboradorLaborales;
import empresaTransporte.utp.util.RespuestaControlador;

import java.util.List;

public interface ColaboradorLabService {

    List<ColaboradorLaborales> listarColaboradoresLaboralesActivos();

    public RespuestaControlador guardar (ColaboradorLaborales colaboradorLaborales);

    public RespuestaControlador actualizar (ColaboradorLaborales colaboradorLaborales);

    public ColaboradorLaborales findById(Long idColaboradorLab);

    ColaboradorLaborales getById(Long id);
}
