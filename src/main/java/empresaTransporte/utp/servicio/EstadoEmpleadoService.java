package empresaTransporte.utp.servicio;


import empresaTransporte.utp.entidad.master.EstadoEmpleado;
import empresaTransporte.utp.repositorio.EstadoEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoEmpleadoService {

    @Autowired
    private EstadoEmpleadoRepository estadoEmpleadoRepository;

    public List<EstadoEmpleado> obtenerEstadosEmpleados() {
        return estadoEmpleadoRepository.findEstadoEmpleadoByActivoTrue();
    }

    public EstadoEmpleado obtenerPorId(Long id) {
        return estadoEmpleadoRepository.getById(id);
    }
}
