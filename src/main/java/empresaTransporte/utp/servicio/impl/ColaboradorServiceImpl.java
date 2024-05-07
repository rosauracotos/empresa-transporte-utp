package empresaTransporte.utp.servicio.impl;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.repositorio.ColaboradorRepository;
import empresaTransporte.utp.servicio.ColaboradorService;
import empresaTransporte.utp.servicio.UsuarioService;
import empresaTransporte.utp.util.RespuestaControlador;
import empresaTransporte.utp.util.RespuestaControladorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {

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
        RespuestaControlador respuestaControlador;
        colaborador.setCodigo(generarCodigoUsuario());
        colaboradorRepository.save(colaborador);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoCrear("Colaborador");
        return respuestaControlador;
    }

    @Override
    public RespuestaControlador actualizar(Colaborador colaborador) {
        RespuestaControlador respuestaControlador;
        colaboradorRepository.save(colaborador);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoActualizar("Colaborador");
        return respuestaControlador;
    }

    @Override
    public Colaborador findById(Long idColaborador) {
        return colaboradorRepository.findById(idColaborador).orElse(null);
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
