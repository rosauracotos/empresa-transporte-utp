package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.master.RegimenPensionario;
import empresaTransporte.utp.servicio.impl.RegimenPensionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/regimenPensionario")
public class RegimenPensionarioController {

    @Autowired
    private RegimenPensionarioService regimenPensionarioService;

    @GetMapping("/all")
    public List<RegimenPensionario> obtenerRegimenPensionario() {
        return regimenPensionarioService.obtenerRegimenPensionario();
    }

    @GetMapping("/{id}")
    public RegimenPensionario obtenerRegimenPensionarioPorId(@PathVariable("id") Long regimenPensionarioId) {
        return regimenPensionarioService.obtenerPorId(regimenPensionarioId);
    }
}
