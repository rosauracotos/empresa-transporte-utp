package empresaTransporte.utp.servicio;

public interface EmailService {

    void enviarCorreo(String destinatario, String asunto, String cuerpo);
}
