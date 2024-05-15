package empresaTransporte.utp.servicio.impl;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.entidad.master.EstadoEmpleado;
import empresaTransporte.utp.repositorio.ColaboradorRepository;
import empresaTransporte.utp.servicio.ColaboradorService;
import empresaTransporte.utp.servicio.UsuarioService;
import empresaTransporte.utp.util.RespuestaControlador;
import empresaTransporte.utp.util.RespuestaControladorServicio;
import empresaTransporte.utp.util.dto.ColaboradorBusquedaRequestDTO;
import empresaTransporte.utp.util.dto.ColaboradorBusquedaResponseDTO;
import empresaTransporte.utp.util.enums.EstadoEmpleadoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;


    @Override
    public List<Colaborador> listarColaboradoresActivos() {
        return colaboradorRepository.findBancoByActivoTrue();
    }

    @Override
    public RespuestaControlador guardar(Colaborador colaborador) {
        RespuestaControlador respuestaControlador;
        colaborador.setCodigo(generarCodigoUsuario());
        colaborador.setFechaIngreso(LocalDate.now());
        EstadoEmpleado estadoEmpleado = new EstadoEmpleado();
        estadoEmpleado.setId(EstadoEmpleadoEnum.CONTRATADO.getId());
        colaborador.setEstadoEmpleado(estadoEmpleado);
        colaboradorRepository.save(colaborador);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoCrear("Colaborador");
        respuestaControlador.setExtraInfo(colaborador.getId());
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
        RespuestaControlador respuestaControlador;
        colaboradorRepository.deleteById(id);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoEliminar("colaborador");
        return respuestaControlador;
    }

    @Override
    public ColaboradorBusquedaResponseDTO busquedaPaginada(ColaboradorBusquedaRequestDTO dto) {
        List<Map<String, Object>> data = colaboradorRepository.busquedaPaginadaColaborador(dto.getNombre(), dto.getApellidoPaterno(), dto.getApellidoMaterno(), dto.getTipoDocumentoId(),
                dto.getNumeroDocumento(), dto.getEstadoEmpleadoId(), dto.getCargoId(), dto.getGrupoLaboralId(), dto.getMax(), dto.getLimite());
        Integer cantidadTotal = colaboradorRepository.busquedaPaginadaColaboradorContar(dto.getNombre(), dto.getApellidoPaterno(), dto.getApellidoMaterno(), dto.getTipoDocumentoId(),
                dto.getNumeroDocumento(), dto.getEstadoEmpleadoId(), dto.getCargoId(), dto.getGrupoLaboralId());
        ColaboradorBusquedaResponseDTO responseDTO = new ColaboradorBusquedaResponseDTO();
        responseDTO.setData(data);
        responseDTO.setPaginaActual(dto.getLimite());
        responseDTO.setTotalRegistros(cantidadTotal);
        responseDTO.setCantidadPorPagina( dto.getMax());
        return responseDTO;
    }

    private String generarCodigoUsuario (){

        Long cantidad = colaboradorRepository.contarColaboradores() + 1;
        String cadenaFormateada = String.format("E%05d", cantidad);


        return cadenaFormateada;

    }
}
