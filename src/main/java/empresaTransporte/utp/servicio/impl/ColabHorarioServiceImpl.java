package empresaTransporte.utp.servicio.impl;

import empresaTransporte.utp.entidad.colaborador.ColaboradorHorario;
import empresaTransporte.utp.repositorio.ColabHorarioRepository;
import empresaTransporte.utp.servicio.ColabHorarioService;
import empresaTransporte.utp.util.RespuestaControlador;
import empresaTransporte.utp.util.RespuestaControladorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColabHorarioServiceImpl implements ColabHorarioService {

    @Autowired
    private ColabHorarioRepository colabHorarioRepository;

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;


    @Override
    public List<ColaboradorHorario> listarColabHorario() {
        return colabHorarioRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(ColaboradorHorario colaboradorHorario) {
        RespuestaControlador respuestaControlador;
        colabHorarioRepository.save(colaboradorHorario);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoCrear("Colaborador Horario");
        return respuestaControlador;
    }

    @Override
    public RespuestaControlador actualizar(ColaboradorHorario colaboradorHorario) {
        return null;
    }

    @Override
    public ColaboradorHorario findById(Integer idColabHorario) {
        return null;
    }
}
