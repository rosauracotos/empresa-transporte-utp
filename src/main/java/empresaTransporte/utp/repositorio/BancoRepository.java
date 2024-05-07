package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.master.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BancoRepository  extends JpaRepository<Banco, Long> {

    List<Banco> findBancoByActivoTrue();

    Optional<Banco> findById(Long id);
}
