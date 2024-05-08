package empresaTransporte.utp.servicio.impl;


import empresaTransporte.utp.entidad.master.TipoDoc;
import empresaTransporte.utp.repositorio.TipoDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocService {

    @Autowired
    private TipoDocRepository tipoDocRepository;

    public List<TipoDoc> obtenerTipoDoc() {
        return tipoDocRepository.findTipoDocByActivoTrue();
    }

    public TipoDoc obtenerPorId(Long id) {
        return tipoDocRepository.findById(id).get();
    }
}
