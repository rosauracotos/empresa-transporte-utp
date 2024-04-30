package empresaTransporte.utp.entidad.ubigeo;

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
@Table(name = "ubigeodep", schema = "ubigeo")
@Getter
@Setter
public class UbigeoDepart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ude_id")
    private Long id;

    @Column(name = "ude_descri")
    private String descripcion;

    @Column(name = "ude_codigo")
    private String codigo;

    @Column(name = "ude_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "ude_activo")
    private boolean activo;
}
