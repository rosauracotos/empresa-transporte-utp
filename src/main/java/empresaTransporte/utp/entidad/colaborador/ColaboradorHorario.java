package empresaTransporte.utp.entidad.colaborador;


import empresaTransporte.utp.entidad.master.Turno;
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
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "coh_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "coh_activo")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "col_id")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "tur_id")
    private Turno turno;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        estado = true;
    }
}
