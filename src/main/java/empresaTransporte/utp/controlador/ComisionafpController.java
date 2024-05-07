package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.master.Comisionafp;
import empresaTransporte.utp.servicio.impl.ComisionafpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Comisionafp")
public class ComisionafpController {

    @Autowired
    private ComisionafpService comisionafpService;

    @GetMapping("/all")
    public List<Comisionafp> obtenerComisionafp() {
        return comisionafpService.obtenerComisionafp();
    }

    @GetMapping("/{id}")
    public Comisionafp obtenerComisionafpPorId(@PathVariable("id") Long comisionafpId) {
        return comisionafpService.obtenerPorId(comisionafpId);
    }


}

