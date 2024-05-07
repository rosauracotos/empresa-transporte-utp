package empresaTransporte.utp.servicio;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.util.RespuestaControlador;
import empresaTransporte.utp.util.dto.LoginRequestDTO;

public interface UsuarioService {

    void crearUsuarioColaborador(Colaborador colaborador);

    RespuestaControlador validarLogin(LoginRequestDTO loginRequestDTO);
    
}
