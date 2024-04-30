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
@Table(name = "turnos", schema = "master")
@Getter
@Setter
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tur_id")
    private Long id;

    @Column(name = "tur_descri")
    private String descripcion;

    @Column(name = "tur_abrevi")
    private String abreviatura;

    @Column(name = "tur_siglas")
    private String siglas;

    @Column(name = "tur_horini")
    private Integer horaInicio;

    @Column(name = "tur_horfin")
    private Integer horaFin;

    @Column(name = "tur_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "tur_activo")
    private boolean activo;
}
