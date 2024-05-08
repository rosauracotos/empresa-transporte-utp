package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.master.RegimenPensionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegimenPensionarioRepository extends JpaRepository<RegimenPensionario, Long> {

    List<RegimenPensionario> findRegimenPensionarioByActivoTrue();

    Optional<RegimenPensionario> findById(Long id);
}
