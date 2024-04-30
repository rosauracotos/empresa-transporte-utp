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
@Table(name = "regimenpensionario", schema = "master")
@Getter
@Setter
public class RegimenPensionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rpe_id")
    private Long id;

    @Column(name = "rpe_descri")
    private String descripcion;

    @Column(name = "rpe_abrevi")
    private String abreviatura;

    @Column(name = "rpe_siglas")
    private String siglas;

    @Column(name = "rpe_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "rpe_activo")
    private boolean activo;
}
