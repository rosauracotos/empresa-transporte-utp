package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.master.Comisionafp;
import empresaTransporte.utp.servicio.ComisionAfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/comisionafp")
public class ComisionAFPController {

    @Autowired
    private ComisionAfpService comisionAfpService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(comisionAfpService.listarComisionAfp());
    }

    @GetMapping("/{id}")
    public Comisionafp obtenerComisionAfpPorId(@PathVariable("id") Long idComisionAfp) {
        return comisionAfpService.findById(idComisionAfp);
    }


}
