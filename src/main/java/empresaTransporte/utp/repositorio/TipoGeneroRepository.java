package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.master.TipoGenero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoGeneroRepository extends JpaRepository<TipoGenero, Long> {

    List<TipoGenero> findTipoGeneroByActivoTrue();

    Optional<TipoGenero> findById(Long id);
}
