package empresaTransporte.utp.servicio.impl;


import empresaTransporte.utp.entidad.area.AreaDen;
import empresaTransporte.utp.repositorio.AreaDenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaDenService {

    @Autowired
    private AreaDenRepository areaDenRepository;

    public List<AreaDen> obtenerAreaDen() {
        return areaDenRepository.findAreaDenByActivoTrue();
    }

    public AreaDen obtenerPorId(Long id) {
        return areaDenRepository.findById(id).get();
    }
}
