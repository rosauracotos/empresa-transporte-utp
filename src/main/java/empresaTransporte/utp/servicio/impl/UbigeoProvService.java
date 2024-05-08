package empresaTransporte.utp.servicio.impl;


import empresaTransporte.utp.entidad.ubigeo.UbigeoProv;
import empresaTransporte.utp.repositorio.UbigeoProvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbigeoProvService {

    @Autowired
    private UbigeoProvRepository ubigeoProvRepository;

    public List<UbigeoProv> obtenerUbigeoProv() {
        return ubigeoProvRepository.findUbigeoProvtByActivoTrue();
    }

    public UbigeoProv obtenerPorId(Long id) {
        return ubigeoProvRepository.findById(id).get();
    }
}
