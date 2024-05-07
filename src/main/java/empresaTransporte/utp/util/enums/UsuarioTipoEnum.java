package empresaTransporte.utp.util.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum UsuarioTipoEnum {

    INTERNO("Interno",1L),
    EXTERNO("Externo", 2L);

    private String nombre;
    private Long id;

    UsuarioTipoEnum(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }
}
