package empresaTransporte.utp.entidad.area;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "areaclasificacion", schema = "area")
@Getter
@Setter
public class AreaClasificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arc_id")
    private Long id;

    @Column(name = "arc_descri")
    private String descripcion;

    @Column(name = "arc_abrevi")
    private String abreviatura;

    @Column(name = "arc_siglas")
    private String siglas;

    @Column(name = "arc_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "arc_activo")
    private boolean activo;
}
