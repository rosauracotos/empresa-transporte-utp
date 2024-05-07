package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.Seguridad.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    Usuarios findByLogin(String login);

}
