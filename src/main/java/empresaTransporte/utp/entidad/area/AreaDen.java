package empresaTransporte.utp.entidad.area;

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
@Table(name = "areadenominacion", schema = "area")
@Getter
@Setter
public class AreaDen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ard_id")
    private Long id;

    @Column(name = "ard_descri")
    private String descripcion;

    @Column(name = "ard_abrevi")
    private String abreviatura;

    @Column(name = "ard_fecini")
    private Timestamp fechaInicio;

    @Column(name = "ard_fecfin")
    private Timestamp fechaFin;

    @Column(name = "ard_chkorg")
    private boolean chkorg;

    @Column(name = "ard_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "ard_activo")
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "are_id")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "arc_id")
    private AreaClasificacion areaClasificacion;

    @ManyToOne
    @JoinColumn(name = "ard_idpadr")
    private Area areaPadre;

}
