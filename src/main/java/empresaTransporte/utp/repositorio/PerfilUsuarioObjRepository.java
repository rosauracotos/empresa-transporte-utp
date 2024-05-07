package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.Seguridad.PerfilUsuario;
import empresaTransporte.utp.entidad.Seguridad.PerfilUsuarioObj;
import empresaTransporte.utp.util.dto.ObjetosMenuResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilUsuarioObjRepository extends JpaRepository<PerfilUsuarioObj, Long> {

    List<PerfilUsuarioObj> findByPerfilUsuarioIdAndActivo(Long id, Boolean activo);

}
