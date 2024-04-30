package empresaTransporte.utp.servicio;


import empresaTransporte.utp.entidad.master.GrupoLaboral;
import empresaTransporte.utp.repositorio.GrupoLaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoLaboralService {

    @Autowired
    private GrupoLaboralRepository grupoLaboralRepository;

    public List<GrupoLaboral> obtenerGrupoLaboral() {
        return grupoLaboralRepository.findGrupoLaboralByActivoTrue();
    }

    public GrupoLaboral obtenerPorId(Long id) {
        return grupoLaboralRepository.getById(id);
    }
}
