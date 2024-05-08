package empresaTransporte.utp.repositorio;



import empresaTransporte.utp.entidad.master.TipoDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoDocRepository extends JpaRepository<TipoDoc, Long> {

    List<TipoDoc> findTipoDocByActivoTrue();

    Optional<TipoDoc> findById(Long id);
}
