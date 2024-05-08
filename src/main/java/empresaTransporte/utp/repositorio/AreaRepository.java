package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.area.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    List<Area> findAreaByActivoTrue();

    Optional<Area> findById(Long id);
}
