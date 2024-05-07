package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.master.Cargo;
import empresaTransporte.utp.servicio.impl.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping("/all")
    public List<Cargo> obtenerCargo() {
        return cargoService.obtenerCargo();
    }

    @GetMapping("/{id}")
    public Cargo obtenerCargoPorId(@PathVariable("id") Long cargoId) {
        return cargoService.obtenerPorId(cargoId);
    }


}

