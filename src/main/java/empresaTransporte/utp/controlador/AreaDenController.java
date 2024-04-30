package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.area.AreaDen;
import empresaTransporte.utp.servicio.AreaDenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/areaDenominacion")
public class AreaDenController {

    @Autowired
    private AreaDenService areaDenService;

    @GetMapping("/all")
    public List<AreaDen> obtenerAreaDen() {
        return areaDenService.obtenerAreaDen();
    }

    @GetMapping("/{id}")
    public AreaDen obtenerAreaDenPorId(@PathVariable("id") Long areaDenId) {
        return areaDenService.obtenerPorId(areaDenId);
    }
}
