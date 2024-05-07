package empresaTransporte.utp.controlador;

import empresaTransporte.utp.entidad.master.TipoGenero;
import empresaTransporte.utp.servicio.impl.TipoGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipoGenero")
public class TipoGeneroController {

    @Autowired
    private TipoGeneroService tipoGeneroService;

    @GetMapping("/all")
    public List<TipoGenero> obtenerTipoGenero() {
        return tipoGeneroService.obtenerTipoGenero();
    }

    @GetMapping("/buscar/{idTipoGen}")
    public ResponseEntity<?> buscar(@PathVariable Long idTipoGen){
        TipoGenero tipoGeneroDb = tipoGeneroService.obtenerPorId(idTipoGen);
        if(tipoGeneroDb!=null) {
            return new ResponseEntity<>(tipoGeneroDb, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
}
