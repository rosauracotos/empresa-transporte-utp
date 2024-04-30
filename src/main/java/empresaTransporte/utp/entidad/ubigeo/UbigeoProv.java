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
@Table(name = "ubigeopro", schema = "ubigeo")
@Getter
@Setter
public class UbigeoProv implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "upr_id")
    private Long id;

    @Column(name = "upr_descri")
    private String descripcion;

    @Column(name = "upr_codigo")
    private String codigo;

    @Column(name = "upr_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "upr_activo")
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "ude_id")
    private UbigeoDepart departamento;
}
