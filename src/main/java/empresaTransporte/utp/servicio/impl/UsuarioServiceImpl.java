package empresaTransporte.utp.servicio.impl;

import empresaTransporte.utp.entidad.Seguridad.Objetos;
import empresaTransporte.utp.entidad.Seguridad.Perfil;
import empresaTransporte.utp.entidad.Seguridad.PerfilUsuario;
import empresaTransporte.utp.entidad.Seguridad.PerfilUsuarioObj;
import empresaTransporte.utp.entidad.Seguridad.UsuarioClave;
import empresaTransporte.utp.entidad.Seguridad.UsuarioTipo;
import empresaTransporte.utp.entidad.Seguridad.Usuarios;
import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.entidad.colaborador.ColaboradorLaborales;
import empresaTransporte.utp.entidad.master.Cargo;
import empresaTransporte.utp.repositorio.ColaboradorLaboralesRepository;
import empresaTransporte.utp.repositorio.ObjetosRepository;
import empresaTransporte.utp.repositorio.PerfilUsuarioObjRepository;
import empresaTransporte.utp.repositorio.PerfilUsuarioRepository;
import empresaTransporte.utp.repositorio.UsuarioClaveRepository;
import empresaTransporte.utp.repositorio.UsuariosRepository;
import empresaTransporte.utp.servicio.ColaboradorService;
import empresaTransporte.utp.servicio.UsuarioService;
import empresaTransporte.utp.util.enums.CargoEnum;
import empresaTransporte.utp.util.enums.PerfilEnum;
import empresaTransporte.utp.util.enums.UsuarioTipoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private UsuarioClaveRepository usuarioClaveRepository;

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    @Autowired
    private ColaboradorLaboralesRepository colaboradorLaboralesRepository;

    @Autowired
    private PerfilUsuarioObjRepository perfilUsuarioObjRepository;

    @Autowired
    private ObjetosRepository objetosRepository;

    @Autowired
    private ColaboradorService colaboradorService;

    // Caracteres que se pueden incluir en la clave
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+{}[]";

    // Longitud de la clave
    private static final int LONGITUD_CLAVE = 15;


    @Override
    public void crearUsuarioColaborador(Colaborador colaboradorCreado) {
        Colaborador colaborador = colaboradorService.findById(colaboradorCreado.getId());
        //Crear usuario
        UsuarioTipo usuarioTipo = new UsuarioTipo();
        usuarioTipo.setId(UsuarioTipoEnum.INTERNO.getId());
        Usuarios usuario = new Usuarios();
        usuario.setLogin(colaborador.getNumeroIdentificacion());
        usuario.setApellidoPaterno(colaborador.getApellidoPaterno());
        usuario.setApellidoMaterno(colaborador.getApellidoMaterno());
        usuario.setNombre(colaborador.getNombre());
        usuario.setCelular(colaborador.getCelular());
        usuario.setCorreo(colaborador.getCorreo());
        usuario.setFechaInicio(colaborador.getFechaIngreso());
        usuario.setFechaFin(colaborador.getFechaIngreso());
        usuario.setUsuarioTipo(usuarioTipo);
        usuario.setColaborador(colaborador);
        usuariosRepository.save(usuario);

        // Crear Usuario Clave
        UsuarioClave usuarioClave = new UsuarioClave();
        usuarioClave.setNumItm(1);
        usuarioClave.setPassword(generarClaveAleatoria());
        usuarioClave.setUsuario(usuario);
        usuarioClaveRepository.save(usuarioClave);

        //Crear perfil usuario
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        Perfil perfil = obtenerPerfilPorCargo(colaborador.getId());
        perfilUsuario.setUsuario(usuario);
        perfilUsuario.setPerfil(perfil);
        perfilUsuarioRepository.save(perfilUsuario);

        //Crear perfil usuario objeto
        PerfilEnum perfilEnum = PerfilEnum.buscarPorId(perfil.getId());
        List<Objetos> listado = objetosRepository.findAllByIds(perfilEnum.getObjetosIds());
        if (!listado.isEmpty()){
            for (Objetos objeto : listado){
                PerfilUsuarioObj perfilUsuarioObj = new PerfilUsuarioObj();
                perfilUsuarioObj.setPerfilUsuario(perfilUsuario);
                perfilUsuarioObj.setObjetos(objeto);
                perfilUsuarioObjRepository.save(perfilUsuarioObj);
            }
        }
    }

    private String generarClaveAleatoria() {
        SecureRandom random = new SecureRandom();
        StringBuilder clave = new StringBuilder();

        // Genera cada carácter de la clave
        for (int i = 0; i < LONGITUD_CLAVE; i++) {
            int indice = random.nextInt(CARACTERES.length());
            char caracter = CARACTERES.charAt(indice);
            clave.append(caracter);
        }

        return clave.toString();
    }

    private Cargo obtenerUltimoCargoColaborador(Long colaboradorId) {
        ColaboradorLaborales colaboradorLaborales = colaboradorLaboralesRepository.findUltimoRegistroActivoByColaboradorId(colaboradorId).get();
        return colaboradorLaborales.getCargo();
    }

    private Perfil obtenerPerfilPorCargo(Long colaboradorId) {
        Cargo cargo = obtenerUltimoCargoColaborador(colaboradorId);
        Perfil perfil = new Perfil();
        if (cargo.getId().equals(CargoEnum.GERENTE.getId())){
            perfil.setId(PerfilEnum.GERENTE.getId());
        } else if (cargo.getId().equals(CargoEnum.SUB_GERENTE.getId())){
            perfil.setId(PerfilEnum.SUB_GERENTE.getId());
        } else if (cargo.getId().equals(CargoEnum.JEFE.getId())){
            perfil.setId(PerfilEnum.JEFE.getId());
        }  else {
            perfil.setId(PerfilEnum.PERSONAL.getId());
        }
        return perfil;
    }
}