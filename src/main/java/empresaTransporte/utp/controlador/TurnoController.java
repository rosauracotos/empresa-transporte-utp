package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.master.Turno;
import empresaTransporte.utp.servicio.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping("/all")
    public List<Turno> obtenerTurno() {
        return turnoService.obtenerTurno();
    }

    @GetMapping("/buscar/{idTurno}")
    public ResponseEntity<?> buscar(@PathVariable Long idTurno){
        Turno turnoDb = turnoService.obtenerPorId(idTurno);
        if(turnoDb!=null) {
            return new ResponseEntity<>(turnoDb, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
}
