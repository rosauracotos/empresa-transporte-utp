package empresaTransporte.utp.servicio.impl;

import empresaTransporte.utp.entidad.master.Banco;
import empresaTransporte.utp.repositorio.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    public List<Banco> obtenerBanco() {
        return bancoRepository.findBancoByActivoTrue();
    }

    public Banco obtenerPorId(Long id) {
        return bancoRepository.findById(id).get();
    }
}

