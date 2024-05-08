package empresaTransporte.utp.controlador;


import empresaTransporte.utp.entidad.ubigeo.UbigeoProv;
import empresaTransporte.utp.servicio.impl.UbigeoProvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ubigeoProvincia")
public class UbigeoProvController {

    @Autowired
    private UbigeoProvService ubigeoProvService;

    @GetMapping("/all")
    public List<UbigeoProv> obtenerUbigeoProv() {
        return ubigeoProvService.obtenerUbigeoProv();
    }

    @GetMapping("/buscar/{idUbiProv}")
    public ResponseEntity<?> buscar(@PathVariable Long idUbiProv){
        UbigeoProv ubigeoProvDb = ubigeoProvService.obtenerPorId(idUbiProv);
        if(ubigeoProvDb!=null) {
            return new ResponseEntity<>(ubigeoProvDb, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/departamento/{idDepartamento}")
    public ResponseEntity<?> obtenerProvinciasPorDepartamento(@PathVariable Long idDepartamento) {
        List<UbigeoProv> provincias = ubigeoProvService.obtenerProvinciasPorDepartamento(idDepartamento);
        if (!provincias.isEmpty()) {
            return new ResponseEntity<>(provincias, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
