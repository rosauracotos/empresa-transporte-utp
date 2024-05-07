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
@Table(name = "comisionafp", schema = "master")
@Getter
@Setter
public class Comisionafp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caf_id")
    private Long id;

    @Column(name = "caf_descri")
    private String descripcion;

    @Column(name = "caf_abrevi")
    private String abreviatura;

    @Column(name = "caf_siglas")
    private String siglas;

    @Column(name = "caf_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "caf_activo")
    private boolean activo;

}

