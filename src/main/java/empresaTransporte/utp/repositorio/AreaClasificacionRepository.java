package empresaTransporte.utp.repositorio;



import empresaTransporte.utp.entidad.area.AreaClasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaClasificacionRepository extends JpaRepository<AreaClasificacion, Integer> {

    List<AreaClasificacion> findAreaClasificacionByActivoTrue();

    AreaClasificacion getById(Long id);
}
