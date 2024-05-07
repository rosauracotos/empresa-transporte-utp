package empresaTransporte.utp.entidad.colaborador;


import empresaTransporte.utp.entidad.master.Turno;
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
import java.time.LocalDate;

@Entity
@Table(name = "colaboradorhorario", schema = "colaborador")
@Getter
@Setter
public class ColaboradorHorario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coh_id")
    private Long id;

    @Column(name = "coh_dialab")
    private LocalDate diaLaboral;

    @Column(name = "coh_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "coh_activo")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "col_id")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "tur_id")
    private Turno turno;
}
