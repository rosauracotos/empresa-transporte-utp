package empresaTransporte.utp.repositorio;



import empresaTransporte.utp.entidad.ubigeo.UbigeoProv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UbigeoProvRepository extends JpaRepository<UbigeoProv, Long> {

    List<UbigeoProv> findUbigeoProvtByActivoTrue();

    Optional<UbigeoProv> findById(Long id);

    List<UbigeoProv> findByDepartamentoIdAndActivoIsTrue(@Param("idDepartamento") Long idDepartamento);

}
