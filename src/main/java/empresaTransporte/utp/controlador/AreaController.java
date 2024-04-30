package empresaTransporte.utp.controlador;

import empresaTransporte.utp.entidad.area.Area;
import empresaTransporte.utp.servicio.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/all")
    public List<Area> obtenerArea() {
        return areaService.obtenerArea();
    }

    @GetMapping("/{id}")
    public Area obtenerAreaPorId(@PathVariable("id") Long areaId) {
        return areaService.obtenerPorId(areaId);
    }
}
