package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.colaborador.ColaboradorLaborales;
import empresaTransporte.utp.servicio.ColaboradorLabService;
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
@RequestMapping("/api/colaboradorLaboral")
public class ColabLabController {

    @Autowired
    private ColaboradorLabService colaboradorLabService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(colaboradorLabService.listarColaboradoresLaboralesActivos());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar (@RequestBody ColaboradorLaborales colaboradorLaborales){
        try {
            RespuestaControlador rc = colaboradorLabService.guardar(colaboradorLaborales);
            return ResponseEntity.ok(rc);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
