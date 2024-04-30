package empresaTransporte.utp.servicio;


import empresaTransporte.utp.entidad.area.AreaClasificacion;
import empresaTransporte.utp.repositorio.AreaClasificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaClasificacionService {

    @Autowired
    private AreaClasificacionRepository areaClasificacionRepository;

    public List<AreaClasificacion> obtenerAreaClasificacion() {
        return areaClasificacionRepository.findAreaClasificacionByActivoTrue();
    }

    public AreaClasificacion obtenerPorId(Long id) {
        return areaClasificacionRepository.getById(id);
    }
}
