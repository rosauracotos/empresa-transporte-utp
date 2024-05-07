package empresaTransporte.utp.servicio.impl;


import empresaTransporte.utp.entidad.master.RegimenPensionario;
import empresaTransporte.utp.repositorio.RegimenPensionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegimenPensionarioService {

    @Autowired
    private RegimenPensionarioRepository regimenPensionarioRepository;

    public List<RegimenPensionario> obtenerRegimenPensionario() {
        return regimenPensionarioRepository.findRegimenPensionarioByActivoTrue();
    }

    public RegimenPensionario obtenerPorId(Long id) {
        return regimenPensionarioRepository.getById(id);
    }
}
