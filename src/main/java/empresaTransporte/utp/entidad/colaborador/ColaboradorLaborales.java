package empresaTransporte.utp.entidad.colaborador;


import empresaTransporte.utp.entidad.area.AreaDen;
import empresaTransporte.utp.entidad.master.Cargo;
import empresaTransporte.utp.entidad.master.GrupoLaboral;
import empresaTransporte.utp.entidad.master.RegimenPensionario;
import empresaTransporte.utp.entidad.master.Sede;
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
@Table(name = "colaborador_laborales", schema = "colaborador")
@Getter
@Setter
public class ColaboradorLaborales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clb_id")
    private Long id;

    @Column(name = "clb_numitm")
    private Integer numItem;

    @Column(name = "clb_ncuspp")
    private String numCupss;

    @ManyToOne
    @JoinColumn(name = "col_id")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "sed_id")
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "grl_id")
    private GrupoLaboral grupoLaboral;

    @ManyToOne
    @JoinColumn(name = "ard_id")
    private AreaDen areaDenominacion;

    @ManyToOne
    @JoinColumn(name = "rpe_id")
    private RegimenPensionario regimenPensionario;

    @ManyToOne
    @JoinColumn(name = "crg_id")
    private Cargo cargo;

    @Column(name = "rpe_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "rpe_activo")
    private Boolean estado;
}
