package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.master.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long> {

    List<Sede> findSedeByActivoTrue();

    Optional<Sede> findById(Long id);
}
