package empresaTransporte.utp.controlador;

import empresaTransporte.utp.entidad.master.GrupoLaboral;
import empresaTransporte.utp.servicio.impl.GrupoLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/grupoLaboral")
public class GrupoLaboralController {

    @Autowired
    private GrupoLaboralService grupoLaboralService;

    @GetMapping("/all")
    public List<GrupoLaboral> obtenerGrupoLaboral() {
        return grupoLaboralService.obtenerGrupoLaboral();
    }

    @GetMapping("/buscar/{idGrupoLab}")
    public ResponseEntity<?> buscar(@PathVariable Long idGrupoLab){
        GrupoLaboral grupoLabDb = grupoLaboralService.obtenerPorId(idGrupoLab);
        if(grupoLabDb!=null) {
            return new ResponseEntity<>(grupoLabDb, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
}
