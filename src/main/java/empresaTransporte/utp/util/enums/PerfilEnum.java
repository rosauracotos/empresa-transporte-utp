package empresaTransporte.utp.util.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum PerfilEnum {

    ADMINISTRADOR("Administrador", 1L, Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9l, 10L, 11L,12L)),
    GERENTE("Gerente", 2L, Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9l, 10L, 11L,12L)),
    SUB_GERENTE("Sub Gerente", 3L, Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9l, 10L, 11L,12L)),
    JEFE("Jefe", 4L, Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9l, 10L, 11L,12L)),
    PERSONAL("Personal", 5L, Arrays.asList(2L, 9L));

    private String nombre;
    private Long id;
    private List<Long> objetosIds;

    PerfilEnum(String nombre, Long id, List<Long> objetosIds) {
        this.nombre = nombre;
        this.id = id;
        this.objetosIds = objetosIds;
    }

    // Método estático para buscar un PerfilEnum por su ID
    public static PerfilEnum buscarPorId(Long id) {
        return Arrays.stream(PerfilEnum.values())
                .filter(perfil -> perfil.getId().equals(id))
                .findFirst()
                .orElse(null); // Devuelve null si no se encuentra ningún perfil con el ID dado
    }

}
