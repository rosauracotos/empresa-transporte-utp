package empresaTransporte.utp.entidad.ubigeo;

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
@Table(name = "ubigeodis", schema = "ubigeo")
@Getter
@Setter
public class UbigeoDist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "udi_id")
    private Long id;

    @Column(name = "udi_descri")
    private String descripcion;

    @Column(name = "udi_codigo")
    private String codigo;

    @Column(name = "udi_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "udi_activo")
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "upr_id")
    private UbigeoProv provincia;
}
