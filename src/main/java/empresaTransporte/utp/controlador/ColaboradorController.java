package empresaTransporte.utp.controlador;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.servicio.ColaboradorService;
import empresaTransporte.utp.util.RespuestaControlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(colaboradorService.listarColaboradores());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar (@RequestBody Colaborador colaborador){
        try {
            RespuestaControlador rc = colaboradorService.guardar(colaborador);
            return ResponseEntity.ok(rc);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
