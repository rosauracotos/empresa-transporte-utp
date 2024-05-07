package empresaTransporte.utp.util.enums;

import lombok.Getter;

@Getter
public enum CargoEnum {

    GERENTE("Gerente", 1L),
    SUB_GERENTE("Sub Gerente", 2L),
    JEFE("Jefe", 3L),
    DESPACHADOR("Despachador", 4L),
    VENDEDOR("Vendedor", 5L),
    CONDUCTOR("Conductor", 6L);

    private String nombre;
    private Long id;

    CargoEnum(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }
}
