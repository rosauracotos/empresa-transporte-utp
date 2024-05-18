package empresaTransporte.utp.servicio.impl;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.entidad.colaborador.ColaboradorHorario;
import empresaTransporte.utp.entidad.master.Turno;
import empresaTransporte.utp.repositorio.ColabHorarioRepository;
import empresaTransporte.utp.repositorio.ColaboradorRepository;
import empresaTransporte.utp.servicio.ColabHorarioService;
import empresaTransporte.utp.util.RespuestaControlador;
import empresaTransporte.utp.util.RespuestaControladorServicio;
import empresaTransporte.utp.util.dto.TurnosLaboralRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ColabHorarioServiceImpl implements ColabHorarioService {

    @Autowired
    private ColabHorarioRepository colabHorarioRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

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
    public RespuestaControlador guardarTurnos(TurnosLaboralRequestDTO turnosLaboralRequestDTO) {
        RespuestaControlador respuestaControlador;
        List<Colaborador> colaboradores = colaboradorRepository.findByIdIn(turnosLaboralRequestDTO.getColaboradoresIds());
        Turno turno = new Turno();
        turno.setId(turnosLaboralRequestDTO.getTurno().getId());
        if (!colaboradores.isEmpty()) {
            for (Colaborador colaborador: colaboradores) {
                for (LocalDate fecha = turnosLaboralRequestDTO.getFechaInicio(); fecha.isBefore(turnosLaboralRequestDTO.getFechaFin()) || fecha.isEqual(turnosLaboralRequestDTO.getFechaFin()); fecha = fecha.plusDays(1)) {
                    ColaboradorHorario horario = colabHorarioRepository.findByColaboradorIdAndDiaLaboral(colaborador.getId(), fecha);
                    if (horario != null) {
                        horario.setTurno(turno);
                        colabHorarioRepository.save(horario);
                    } else {
                        ColaboradorHorario colaboradorHorario = new ColaboradorHorario();
                        colaboradorHorario.setTurno(turno);
                        colaboradorHorario.setColaborador(colaborador);
                        colaboradorHorario.setDiaLaboral(fecha);
                        colabHorarioRepository.save(colaboradorHorario);
                    }
                }
            }
        }
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
