package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.master.EstadoEmpleado;
import empresaTransporte.utp.servicio.impl.EstadoEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estadoEmpleado")
public class EstadoEmpleadoController {

    @Autowired
    private EstadoEmpleadoService estadoEmpleadoService;

    @GetMapping("/all")
    public List<EstadoEmpleado> obtenerEstadosEmpleados() {
        return estadoEmpleadoService.obtenerEstadosEmpleados();
    }

    @GetMapping("/{id}")
    public EstadoEmpleado obtenerEstadoEmpleadoPorId(@PathVariable("id") Long estadoEmpleadoId) {
        return estadoEmpleadoService.obtenerPorId(estadoEmpleadoId);
    }
}
