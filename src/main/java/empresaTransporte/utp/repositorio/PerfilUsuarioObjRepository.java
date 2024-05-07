package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.Seguridad.PerfilUsuarioObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilUsuarioObjRepository extends JpaRepository<PerfilUsuarioObj, Long> {
}
