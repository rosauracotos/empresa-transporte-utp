package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.master.RegimenPensionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegimenPensionarioRepository extends JpaRepository<RegimenPensionario, Long> {

    List<RegimenPensionario> findRegimenPensionarioByActivoTrue();

    RegimenPensionario getById(Long id);
}
