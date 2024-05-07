package empresaTransporte.utp.servicio.impl;

import empresaTransporte.utp.entidad.colaborador.ColaboradorLaborales;
import empresaTransporte.utp.repositorio.ColaboradorLaboralesRepository;
import empresaTransporte.utp.servicio.ColaboradorLabService;
import empresaTransporte.utp.servicio.UsuarioService;
import empresaTransporte.utp.util.RespuestaControlador;
import empresaTransporte.utp.util.RespuestaControladorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorLaboralServiceImpl implements ColaboradorLabService {

    @Autowired
    private ColaboradorLaboralesRepository colaboradorLaboralesRepository;

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public List<ColaboradorLaborales> listarColaboradoresLaborales() {
        return colaboradorLaboralesRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(ColaboradorLaborales colaboradorLaborales) {
        RespuestaControlador respuestaControlador;
        colaboradorLaboralesRepository.save(colaboradorLaborales);
        usuarioService.crearUsuarioColaborador(colaboradorLaborales.getColaborador());
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoCrear("Colaborador Laboral");
        return respuestaControlador;
    }

    @Override
    public RespuestaControlador actualizar(ColaboradorLaborales colaboradorLaborales) {
        return null;
    }

    @Override
    public ColaboradorLaborales findById(Integer idColaboradorLab) {
        return null;
    }
}
