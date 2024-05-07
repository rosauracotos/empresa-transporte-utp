package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.ubigeo.UbigeoDepart;
import empresaTransporte.utp.servicio.impl.UbigeoDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ubigeoDepartamento")
public class UbigeoDepartController {

    @Autowired
    private UbigeoDepartService ubigeoDepartService;

    @GetMapping("/all")
    public List<UbigeoDepart> obtenerUbigeoDepart() {
        return ubigeoDepartService.obtenerUbigeoDepart();
    }

    @GetMapping("/{id}")
    public UbigeoDepart obtenerUbigeoDepartamentoPorId(@PathVariable("id") Long ubigeoDepartId) {
        return ubigeoDepartService.obtenerPorId(ubigeoDepartId);
    }
}
