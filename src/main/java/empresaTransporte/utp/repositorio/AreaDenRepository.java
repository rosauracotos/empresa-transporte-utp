package empresaTransporte.utp.repositorio;



import empresaTransporte.utp.entidad.area.AreaDen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaDenRepository extends JpaRepository<AreaDen, Long> {

    List<AreaDen> findAreaDenByActivoTrue();

    AreaDen getById(Long id);
}
