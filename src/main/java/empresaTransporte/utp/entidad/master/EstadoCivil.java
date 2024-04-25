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
@Table(name = "estadocivil", schema = "master")
@Getter
@Setter
public class EstadoCivil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "esc_id")
    private Long id;

    @Column(name = "esc_descri")
    private String descripcion;

    @Column(name = "esc_abrevi")
    private String abreviatura;

    @Column(name = "esc_siglas")
    private String siglas;

    @Column(name = "esc_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "esc_activo")
    private boolean activo;

}
