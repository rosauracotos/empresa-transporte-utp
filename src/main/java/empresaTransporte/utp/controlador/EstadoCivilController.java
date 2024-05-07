package empresaTransporte.utp.controlador;

import empresaTransporte.utp.entidad.master.EstadoCivil;
import empresaTransporte.utp.servicio.impl.EstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estadoCivil")
public class EstadoCivilController {

    @Autowired
    private EstadoCivilService estadoCivilService;

    @GetMapping("/all")
    public List<EstadoCivil> obtenerEstadosCiviles() {
        return estadoCivilService.obtenerEstadosCiviles();
    }

    @GetMapping("/{id}")
    public EstadoCivil obtenerEstadoCivilPorId(@PathVariable("id") Long estadoCivilId) {
        return estadoCivilService.obtenerPorId(estadoCivilId);
    }
}
