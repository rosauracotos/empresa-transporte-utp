package empresaTransporte.utp.controlador;

import empresaTransporte.utp.entidad.colaborador.ColaboradorHorario;
import empresaTransporte.utp.servicio.ColabHorarioService;
import empresaTransporte.utp.util.RespuestaControlador;
import empresaTransporte.utp.util.dto.TurnosLaboralRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/colaboradorHorario")
public class ColabHorarioController {

    @Autowired
    private ColabHorarioService colabHorarioService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(colabHorarioService.listarColabHorario());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar (@RequestBody ColaboradorHorario colaboradorHorario){
        try {
            RespuestaControlador rc = colabHorarioService.guardar(colaboradorHorario);
            return ResponseEntity.ok(rc);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PostMapping("/guardarTurnos")
    public ResponseEntity<?> guardarTurnos(@RequestBody TurnosLaboralRequestDTO turnosLaboralRequestDTO){
        RespuestaControlador rc = colabHorarioService.guardarTurnos(turnosLaboralRequestDTO);
        return ResponseEntity.ok(rc);
    }
}
