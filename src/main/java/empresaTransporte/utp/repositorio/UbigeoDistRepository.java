package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.ubigeo.UbigeoDist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbigeoDistRepository extends JpaRepository<UbigeoDist, Long> {

    List<UbigeoDist> findUbigeoDistByActivoTrue();

    UbigeoDist getById(Long id);
}
