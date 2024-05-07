package empresaTransporte.utp.servicio.impl;


import empresaTransporte.utp.entidad.master.Comisionafp;
import empresaTransporte.utp.repositorio.ComisionAFPRepository;
import empresaTransporte.utp.servicio.ComisionAfpService;
import empresaTransporte.utp.util.RespuestaControladorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComisionAfpServiceImpl implements ComisionAfpService {

    @Autowired
    private ComisionAFPRepository comisionAFPRepository;

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Override
    public List<Comisionafp> listarComisionAfp() {
        return comisionAFPRepository.findAll();
    }

    @Override
    public Comisionafp findById(Long idComisionAfp) {
        return comisionAFPRepository.findById(idComisionAfp).orElse(null);
    }
}
