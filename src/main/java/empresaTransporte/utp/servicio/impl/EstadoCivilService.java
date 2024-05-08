package empresaTransporte.utp.servicio.impl;

import empresaTransporte.utp.entidad.master.EstadoCivil;
import empresaTransporte.utp.repositorio.EstadoCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCivilService {

    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

    public List<EstadoCivil> obtenerEstadosCiviles() {
        return estadoCivilRepository.findEstadoCivilByActivoTrue();
    }

    public EstadoCivil obtenerPorId(Long id) {
        return estadoCivilRepository.findById(id).get();
    }


}
