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
@Table(name = "area", schema = "area")
@Getter
@Setter
public class Area implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "are_id")
    private Long id;

    @Column(name = "are_descri")
    private String descripcion;

    @Column(name = "are_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "are_activo")
    private boolean activo;
}
