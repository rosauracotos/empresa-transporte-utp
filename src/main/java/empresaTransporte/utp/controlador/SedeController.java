package empresaTransporte.utp.controlador;

import empresaTransporte.utp.entidad.master.Sede;
import empresaTransporte.utp.servicio.impl.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sede")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping("/all")
    public List<Sede> obtenerSede() {
        return sedeService.obtenerSede();
    }

    @GetMapping("/buscar/{idSede}")
    public ResponseEntity<?> buscar(@PathVariable Long idSede){
        Sede sedeDb = sedeService.obtenerPorId(idSede);
        if(sedeDb!=null) {
            return new ResponseEntity<>(sedeDb, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
}
