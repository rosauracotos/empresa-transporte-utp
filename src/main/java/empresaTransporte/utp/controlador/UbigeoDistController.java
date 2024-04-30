package empresaTransporte.utp.controlador;

import empresaTransporte.utp.entidad.ubigeo.UbigeoDist;
import empresaTransporte.utp.servicio.UbigeoDistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ubigeoDistrito")
public class UbigeoDistController {

    @Autowired
    private UbigeoDistService ubigeoDistService;

    @GetMapping("/all")
    public List<UbigeoDist> obtenerUbigeoDist() {
        return ubigeoDistService.obtenerUbigeoDist();
    }

    @GetMapping("/buscar/{idUbiDist}")
    public ResponseEntity<?> buscar(@PathVariable Long idUbiDist){
        UbigeoDist ubigeoDistDB = ubigeoDistService.obtenerPorId(idUbiDist);
        if(ubigeoDistDB!=null) {
            return new ResponseEntity<>(ubigeoDistDB, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
}
