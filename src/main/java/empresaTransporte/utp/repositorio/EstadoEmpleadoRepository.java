package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.master.EstadoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoEmpleadoRepository extends JpaRepository<EstadoEmpleado, Integer> {

    List<EstadoEmpleado> findEstadoEmpleadoByActivoTrue();

    EstadoEmpleado getById(Long id);
}
