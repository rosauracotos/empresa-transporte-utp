package empresaTransporte.utp.servicio;

import empresaTransporte.utp.entidad.master.Cargo;
import empresaTransporte.utp.repositorio.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public List<Cargo> obtenerCargo() {
        return cargoRepository.findCargoByActivoTrue();
    }

    public Cargo obtenerPorId(Long id) {
        return cargoRepository.getById(id);
    }
}
