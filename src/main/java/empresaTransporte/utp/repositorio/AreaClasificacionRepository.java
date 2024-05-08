package empresaTransporte.utp.repositorio;



import empresaTransporte.utp.entidad.area.AreaClasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AreaClasificacionRepository extends JpaRepository<AreaClasificacion, Long> {

    List<AreaClasificacion> findAreaClasificacionByActivoTrue();

    Optional<AreaClasificacion> findById(Long id);
}
