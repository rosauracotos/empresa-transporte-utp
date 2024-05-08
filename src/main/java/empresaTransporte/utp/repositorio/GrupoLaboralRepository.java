package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.master.GrupoLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrupoLaboralRepository extends JpaRepository<GrupoLaboral, Long> {

    List<GrupoLaboral> findGrupoLaboralByActivoTrue();

    Optional<GrupoLaboral> findById(Long id);
}
