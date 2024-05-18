package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.colaborador.ColaboradorLaborales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColaboradorLaboralesRepository extends JpaRepository<ColaboradorLaborales, Long> {

    List<ColaboradorLaborales> findColabLaboralByEstadoTrue();

    ColaboradorLaborales findByColaboradorIdAndEstadoTrue(Long colaboradorId);

    @Query("SELECT cl FROM ColaboradorLaborales cl " +
            "WHERE cl.colaborador.id = :colaboradorId " +
            "AND cl.estado = true " +
            "ORDER BY cl.fechaRegistro DESC LIMIT 1")
    Optional<ColaboradorLaborales> findUltimoRegistroActivoByColaboradorId(@Param("colaboradorId") Long colaboradorId);


}
