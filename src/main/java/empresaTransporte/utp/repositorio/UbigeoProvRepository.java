package empresaTransporte.utp.repositorio;



import empresaTransporte.utp.entidad.ubigeo.UbigeoProv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbigeoProvRepository extends JpaRepository<UbigeoProv, Integer> {

    List<UbigeoProv> findUbigeoProvtByActivoTrue();

    UbigeoProv getById(Long id);
}
