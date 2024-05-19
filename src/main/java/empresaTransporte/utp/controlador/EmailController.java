package empresaTransporte.utp.controlador;

import empresaTransporte.utp.servicio.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-correo")
    public String enviarCorreo() {
        emailService.enviarCorreo("kevinlozada1102@gmail.com", "1", "2");
        return "Correo enviado exitosamente";
    }
}
