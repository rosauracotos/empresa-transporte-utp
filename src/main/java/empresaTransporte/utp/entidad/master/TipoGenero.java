package empresaTransporte.utp.entidad.master;

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
@Table(name = "tipogenero", schema = "master")
@Getter
@Setter
public class TipoGenero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tge_id")
    private Long id;

    @Column(name = "tge_descri")
    private String descripcion;

    @Column(name = "tge_abrevi")
    private String abreviatura;

    @Column(name = "tge_siglas")
    private String siglas;

    @Column(name = "tge_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "tge_activo")
    private boolean activo;
}
