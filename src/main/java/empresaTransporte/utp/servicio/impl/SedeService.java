package empresaTransporte.utp.servicio.impl;


import empresaTransporte.utp.entidad.master.Sede;
import empresaTransporte.utp.repositorio.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    public List<Sede> obtenerSede() {
        return sedeRepository.findSedeByActivoTrue();
    }

    public Sede obtenerPorId(Long id) {
        return sedeRepository.getById(id);
    }
}
