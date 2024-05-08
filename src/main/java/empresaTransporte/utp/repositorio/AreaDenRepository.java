package empresaTransporte.utp.repositorio;



import empresaTransporte.utp.entidad.area.AreaDen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AreaDenRepository extends JpaRepository<AreaDen, Long> {

    List<AreaDen> findAreaDenByActivoTrue();

    Optional<AreaDen> findById(Long id);
}
