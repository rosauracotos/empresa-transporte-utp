package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.entidad.colaborador.ColaboradorLaborales;
import empresaTransporte.utp.servicio.ColaboradorLabService;
import empresaTransporte.utp.util.RespuestaControlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/obtenerPorColaborador/{id}")
    public ResponseEntity<?> obtenerPorColaboradorId(@PathVariable("id") Long colaboradorId) {
        return ResponseEntity.ok(colaboradorLabService.getById(colaboradorId));
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

    @PutMapping("/editar/{idColaboradorLaboral}")
    public ResponseEntity<?> editar(@PathVariable Long idColaboradorLaboral, @RequestBody ColaboradorLaborales newColaboradorLaboral) {
        ColaboradorLaborales colaboradorLaboralDb = colaboradorLabService.findById(idColaboradorLaboral);
        if (colaboradorLaboralDb != null) {
            colaboradorLaboralDb.setNumCupss(newColaboradorLaboral.getNumCupss());
            colaboradorLaboralDb.setNumeroCuenta(newColaboradorLaboral.getNumeroCuenta());
            colaboradorLaboralDb.setGrupoLaboral(newColaboradorLaboral.getGrupoLaboral());
            colaboradorLaboralDb.setAreaDenominacion(newColaboradorLaboral.getAreaDenominacion());
            colaboradorLaboralDb.setBanco(newColaboradorLaboral.getBanco());
            colaboradorLaboralDb.setRegimenPensionario(newColaboradorLaboral.getRegimenPensionario());
            colaboradorLaboralDb.setComisionafp(newColaboradorLaboral.getComisionafp());
            colaboradorLaboralDb.setSede(newColaboradorLaboral.getSede());
            colaboradorLaboralDb.setCargo(newColaboradorLaboral.getCargo());
            RespuestaControlador rc = colaboradorLabService.actualizar(colaboradorLaboralDb);
            return ResponseEntity.ok(rc);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
