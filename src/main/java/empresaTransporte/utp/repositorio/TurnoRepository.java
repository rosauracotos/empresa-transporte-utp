package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.master.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {

    List<Turno> findTurnoByActivoTrue();

    Turno getById(Long id);
}
