package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.Seguridad.UsuarioClave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioClaveRepository extends JpaRepository<UsuarioClave, Long> {
}
