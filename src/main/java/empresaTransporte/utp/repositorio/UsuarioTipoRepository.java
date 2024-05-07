package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.Seguridad.UsuarioTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioTipoRepository extends JpaRepository<UsuarioTipo, Long> {
}
