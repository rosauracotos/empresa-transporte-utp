package empresaTransporte.utp.servicio;



import empresaTransporte.utp.entidad.master.Comisionafp;

import java.util.List;

public interface ComisionAfpService {

    List<Comisionafp> listarComisionAfp();

    Comisionafp findById(Long idComisionAfp);
}
