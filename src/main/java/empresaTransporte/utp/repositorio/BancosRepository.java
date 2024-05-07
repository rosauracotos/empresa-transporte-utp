package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.master.Bancos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancosRepository extends JpaRepository<Bancos, Long> {

    List<Bancos> findBancosByActivoTrue();

    Bancos getById(Long id);

}
