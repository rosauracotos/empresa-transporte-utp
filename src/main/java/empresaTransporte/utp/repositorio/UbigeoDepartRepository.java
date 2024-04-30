package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.ubigeo.UbigeoDepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbigeoDepartRepository extends JpaRepository<UbigeoDepart, Integer> {

    List<UbigeoDepart> findUbigeoDepartByActivoTrue();

    UbigeoDepart getById(Long id);
}
