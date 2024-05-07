package empresaTransporte.utp.servicio.impl;


import empresaTransporte.utp.entidad.master.Turno;
import empresaTransporte.utp.repositorio.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    public List<Turno> obtenerTurno() {
        return turnoRepository.findTurnoByActivoTrue();
    }

    public Turno obtenerPorId(Long id) {
        return turnoRepository.getById(id);
    }
}
