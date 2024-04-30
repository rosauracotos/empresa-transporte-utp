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
@Table(name = "grupolaboral", schema = "master")
@Getter
@Setter
public class GrupoLaboral implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grl_id")
    private Long id;

    @Column(name = "grl_descri")
    private String descripcion;

    @Column(name = "grl_abrevi")
    private String abreviatura;

    @Column(name = "grl_siglas")
    private String siglas;

    @Column(name = "grl_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "grl_activo")
    private boolean activo;
}
