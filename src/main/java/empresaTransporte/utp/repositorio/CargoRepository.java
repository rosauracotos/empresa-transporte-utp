package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.master.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    List<Cargo> findCargoByActivoTrue();

    Optional<Cargo> findById(Long id);

}
