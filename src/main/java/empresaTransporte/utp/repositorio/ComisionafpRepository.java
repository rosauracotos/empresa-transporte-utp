package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.master.Comisionafp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComisionafpRepository extends JpaRepository<Comisionafp, Long> {

    List<Comisionafp> findComisionafpByActivoTrue();

    Comisionafp getById(Long id);

}
