package empresaTransporte.utp.controlador;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.servicio.ColaboradorService;
import empresaTransporte.utp.util.RespuestaControlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        return ResponseEntity.ok(colaboradorService.listarColaboradoresActivos());
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

    @PutMapping("/editar/{idColaborador}")
    public ResponseEntity<?> editar(@PathVariable Long idColaborador, @RequestBody Colaborador newColaborador) {
        Colaborador colaboradorDb = colaboradorService.findById(idColaborador);
        if (colaboradorDb != null) {
            colaboradorDb.setApellidoPaterno(newColaborador.getApellidoPaterno());
            colaboradorDb.setApellidoMaterno(newColaborador.getApellidoMaterno());
            colaboradorDb.setNombre(newColaborador.getNombre());
            colaboradorDb.setNumeroIdentificacion(newColaborador.getNumeroIdentificacion());
            colaboradorDb.setFechaNacimiento(newColaborador.getFechaNacimiento());
            colaboradorDb.setTelefono(newColaborador.getTelefono());
            colaboradorDb.setCelular(newColaborador.getCelular());
            colaboradorDb.setNumeroRuc(newColaborador.getNumeroRuc());
            colaboradorDb.setDireccion(newColaborador.getDireccion());
            colaboradorDb.setCorreo(newColaborador.getCorreo());
            colaboradorDb.setFechaIngreso(newColaborador.getFechaIngreso());
            colaboradorDb.setTipoDocumento(newColaborador.getTipoDocumento());
            colaboradorDb.setTipoGenero(newColaborador.getTipoGenero());
            colaboradorDb.setEstadoCivil(newColaborador.getEstadoCivil());
            colaboradorDb.setEstadoEmpleado(newColaborador.getEstadoEmpleado());
            colaboradorDb.setDistrito(newColaborador.getDistrito());

            colaboradorService.actualizar(colaboradorDb);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> desactivarColaborador(@PathVariable Long id) {
        Colaborador colaboradorDb = colaboradorService.findById(id);
        if (colaboradorDb != null) {
            colaboradorDb.setActivo(false); // Cambia el estado del colaborador a false
            colaboradorService.actualizar(colaboradorDb);
            return ResponseEntity.ok("Colaborador desactivado exitosamente.");
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
