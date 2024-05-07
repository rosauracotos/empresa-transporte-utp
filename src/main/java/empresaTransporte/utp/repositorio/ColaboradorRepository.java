package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    @Query("SELECT COUNT(c) FROM Colaborador c")
    long contarColaboradores();




}
