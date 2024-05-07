package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.master.Bancos;
import empresaTransporte.utp.servicio.impl.BancosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bancos")
public class BancosController {

    @Autowired
    private BancosService bancosService;

    @GetMapping("/all")
    public List<Bancos> obtenerBancos() {
        return bancosService.obtenerBancos();
    }

    @GetMapping("/{id}")
    public Bancos obtenerBancosPorId(@PathVariable("id") Long bancosId) {
        return bancosService.obtenerPorId(bancosId);
    }
}

