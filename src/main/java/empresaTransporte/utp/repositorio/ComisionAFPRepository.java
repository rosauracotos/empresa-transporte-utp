package empresaTransporte.utp.repositorio;


import empresaTransporte.utp.entidad.master.Comisionafp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ComisionAFPRepository extends JpaRepository<Comisionafp, Long> {



}
