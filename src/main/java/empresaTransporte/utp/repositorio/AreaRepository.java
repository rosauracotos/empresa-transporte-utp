package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.area.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

    List<Area> findAreaByActivoTrue();

    Area getById(Long id);
}
