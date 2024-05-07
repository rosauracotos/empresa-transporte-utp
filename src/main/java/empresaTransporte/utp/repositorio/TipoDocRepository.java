package empresaTransporte.utp.repositorio;



import empresaTransporte.utp.entidad.master.TipoDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoDocRepository extends JpaRepository<TipoDoc, Long> {

    List<TipoDoc> findTipoDocByActivoTrue();

    TipoDoc getById(Long id);
}
