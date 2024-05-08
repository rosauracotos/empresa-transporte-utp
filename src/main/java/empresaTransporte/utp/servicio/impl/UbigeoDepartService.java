package empresaTransporte.utp.servicio.impl;


import empresaTransporte.utp.entidad.ubigeo.UbigeoDepart;
import empresaTransporte.utp.repositorio.UbigeoDepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbigeoDepartService {

    @Autowired
    private UbigeoDepartRepository ubigeoDepartRepository;

    public List<UbigeoDepart> obtenerUbigeoDepart() {
        return ubigeoDepartRepository.findUbigeoDepartByActivoTrue();
    }

    public UbigeoDepart obtenerPorId(Long id) {
        return ubigeoDepartRepository.findById(id).get();
    }
}
