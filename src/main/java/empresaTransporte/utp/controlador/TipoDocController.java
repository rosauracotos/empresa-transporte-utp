package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.master.TipoDoc;
import empresaTransporte.utp.servicio.impl.TipoDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipoDocumento")
public class TipoDocController {

    @Autowired
    private TipoDocService tipoDocService;

    @GetMapping("/all")
    public List<TipoDoc> obtenerTipoDocumento() {
        return tipoDocService.obtenerTipoDoc();
    }

    @GetMapping("/buscar/{idTipoDoc}")
    public ResponseEntity<?> buscar(@PathVariable Long idTipoDoc){
        TipoDoc tipoDocDb = tipoDocService.obtenerPorId(idTipoDoc);
        if(tipoDocDb!=null) {
            return new ResponseEntity<>(tipoDocDb, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
}
