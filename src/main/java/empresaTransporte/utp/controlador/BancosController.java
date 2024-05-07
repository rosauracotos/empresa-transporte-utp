package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.master.Banco;
import empresaTransporte.utp.servicio.impl.BancoService;
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
    private BancoService bancosService;

    @GetMapping("/all")
        public List<Banco> obtenerBancos() {
        return bancosService.obtenerBanco();
    }

    @GetMapping("/{id}")
    public Banco obtenerBancosPorId(@PathVariable("id") Long id) {
        return bancosService.obtenerPorId(id);
    }
}

