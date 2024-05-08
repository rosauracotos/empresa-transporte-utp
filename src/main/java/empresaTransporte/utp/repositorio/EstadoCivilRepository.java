package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.master.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long> {

    List<EstadoCivil> findEstadoCivilByActivoTrue();

    Optional<EstadoCivil> findById(Long id);

}
