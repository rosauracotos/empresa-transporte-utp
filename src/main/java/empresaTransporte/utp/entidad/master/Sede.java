package empresaTransporte.utp.entidad.master;

import empresaTransporte.utp.entidad.ubigeo.UbigeoDist;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "sede", schema = "master")
@Getter
@Setter
public class Sede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sed_id")
    private Long id;

    @Column(name = "sed_descri")
    private String descripcion;

    @Column(name = "sed_abrevi")
    private String abreviatura;

    @Column(name = "sed_siglas")
    private String siglas;

    @Column(name = "sed_direcc")
    private String direccion;

    @Column(name = "sed_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "sed_activo")
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "udi_id")
    private UbigeoDist distrito;


}
