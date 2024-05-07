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
@Table(name = "cargo", schema = "master")
@Getter
@Setter
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crg_id")
    private Long id;

    @Column(name = "crg_descri")
    private String descripcion;

    @Column(name = "crg_abrevi")
    private String abreviatura;

    @Column(name = "crg_siglas")
    private String siglas;

    @Column(name = "crg_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "crg_activo")
    private boolean activo;
}

