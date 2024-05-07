package empresaTransporte.utp.servicio.impl;


import empresaTransporte.utp.entidad.area.Area;
import empresaTransporte.utp.repositorio.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public List<Area> obtenerArea() {
        return areaRepository.findAreaByActivoTrue();
    }

    public Area obtenerPorId(Long id) {
        return areaRepository.getById(id);
    }
}
