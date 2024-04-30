package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.master.GrupoLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoLaboralRepository extends JpaRepository<GrupoLaboral, Integer> {

    List<GrupoLaboral> findGrupoLaboralByActivoTrue();

    GrupoLaboral getById(Long id);
}
