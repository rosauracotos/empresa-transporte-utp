package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.colaborador.ColaboradorHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColabHorarioRepository extends JpaRepository<ColaboradorHorario, Long> {
}
