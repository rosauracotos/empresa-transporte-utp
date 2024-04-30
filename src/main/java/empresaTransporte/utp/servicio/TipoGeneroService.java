package empresaTransporte.utp.servicio;


import empresaTransporte.utp.entidad.master.TipoGenero;
import empresaTransporte.utp.repositorio.TipoGeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoGeneroService {

    @Autowired
    private TipoGeneroRepository tipoGeneroRepository;

    public List<TipoGenero> obtenerTipoGenero() {
        return tipoGeneroRepository.findTipoGeneroByActivoTrue();
    }

    public TipoGenero obtenerPorId(Long id) {
        return tipoGeneroRepository.getById(id);
    }
}
