package empresaTransporte.utp.servicio;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.repositorio.ColaboradorRepository;
import empresaTransporte.utp.util.RespuestaControlador;
import empresaTransporte.utp.util.RespuestaControladorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ColaboradorServiceImpl implements  ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;


    @Override
    public List<Colaborador> listarColaboradores() {
        return colaboradorRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(Colaborador colaborador) {
        //LocalDateTime fechaActual = LocalDateTime.now();
        RespuestaControlador respuestaControlador;
     //   colaborador.setFechaRegistro(fechaActual);
       // colaborador.setActivo(true);
        colaborador.setCodigo(generarCodigoUsuario());
        colaboradorRepository.save(colaborador);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoCrear("Colaborador");
        return respuestaControlador;
    }

    @Override
    public RespuestaControlador actualizar(Colaborador colaborador) {
        return null;
    }

    @Override
    public RespuestaControlador eliminar(Long id) {
        return null;
    }

    private String generarCodigoUsuario (){

        Long cantidad = colaboradorRepository.contarColaboradores() + 1;
        String cadenaFormateada = String.format("E%05d", cantidad);


        return cadenaFormateada;

    }
}
