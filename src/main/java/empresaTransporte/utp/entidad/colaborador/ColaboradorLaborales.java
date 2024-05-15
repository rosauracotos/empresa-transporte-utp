package empresaTransporte.utp.entidad.colaborador;


import empresaTransporte.utp.entidad.area.AreaDen;
import empresaTransporte.utp.entidad.master.Banco;
import empresaTransporte.utp.entidad.master.Cargo;
import empresaTransporte.utp.entidad.master.Comisionafp;
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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rpe_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "rpe_activo")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ban_id")
    private Banco banco;

    @ManyToOne
    @JoinColumn(name = "caf_id")
    private Comisionafp comisionafp;

    @Column(name = "clb_numcuenta")
    private String numeroCuenta;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        estado = true;
    }
}
