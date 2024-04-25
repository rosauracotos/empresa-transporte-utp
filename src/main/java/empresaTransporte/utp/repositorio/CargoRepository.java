package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.master.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

    List<Cargo> findCargoByActivoTrue();

    Cargo getById(Long id);

}
