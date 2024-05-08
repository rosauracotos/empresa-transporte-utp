package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.master.EstadoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoEmpleadoRepository extends JpaRepository<EstadoEmpleado, Long> {

    List<EstadoEmpleado> findEstadoEmpleadoByActivoTrue();

    Optional<EstadoEmpleado> findById(Long id);
}
