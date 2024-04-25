package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.master.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Integer> {

    List<EstadoCivil> findEstadoCivilByActivoTrue();

    EstadoCivil getById(Long id);

}
