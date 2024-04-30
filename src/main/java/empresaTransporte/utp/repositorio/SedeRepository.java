package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.master.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer> {

    List<Sede> findSedeByActivoTrue();

    Sede getById(Long id);
}
