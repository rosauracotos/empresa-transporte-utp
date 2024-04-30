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
@Table(name = "estadoempleado", schema = "master")
@Getter
@Setter
public class EstadoEmpleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ese_id")
    private Long id;

    @Column(name = "ese_descri")
    private String descripcion;

    @Column(name = "ese_abrevi")
    private String abreviatura;

    @Column(name = "ese_siglas")
    private String siglas;

    @Column(name = "ese_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "ese_activo")
    private boolean activo;
}
