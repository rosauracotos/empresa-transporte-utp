package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.ubigeo.UbigeoDepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UbigeoDepartRepository extends JpaRepository<UbigeoDepart, Long> {

    List<UbigeoDepart> findUbigeoDepartByActivoTrue();

    Optional<UbigeoDepart> findById(Long id);
}
