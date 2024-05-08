package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.master.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {

    List<Turno> findTurnoByActivoTrue();

    Optional<Turno> findById(Long id);
}
