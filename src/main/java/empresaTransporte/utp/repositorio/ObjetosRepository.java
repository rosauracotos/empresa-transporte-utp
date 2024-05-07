package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.Seguridad.Objetos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjetosRepository extends JpaRepository<Objetos, Long> {

    @Query("SELECT o FROM Objetos o WHERE o.id IN :ids")
    List<Objetos> findAllByIds(@Param("ids") List<Long> ids);

}
