package empresaTransporte.utp.controlador;

import empresaTransporte.utp.entidad.area.AreaClasificacion;
import empresaTransporte.utp.servicio.AreaClasificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/areaClasificacion")
public class AreaClasificacionController {

    @Autowired
    private AreaClasificacionService areaClasificacionService;

    @GetMapping("/all")
    public List<AreaClasificacion> obtenerAreaClasificacion() {
        return areaClasificacionService.obtenerAreaClasificacion();
    }

    @GetMapping("/{id}")
    public AreaClasificacion obtenerAreaClasificacionPorId(@PathVariable("id") Long areaClasificacionId) {
        return areaClasificacionService.obtenerPorId(areaClasificacionId);
    }
}
