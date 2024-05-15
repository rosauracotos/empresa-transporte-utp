package empresaTransporte.utp.util.enums;

import lombok.Getter;

@Getter
public enum EstadoEmpleadoEnum {

    CONTRATADO("CONTRATADO", 1L),
    SUSPENDIDO("SUSPENDIDO", 2L),
    CESADO("CESADO", 3L);
    private String nombre;
    private Long id;

    EstadoEmpleadoEnum(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }
}
