package empresaTransporte.utp.entidad.colaborador;

import empresaTransporte.utp.entidad.master.EstadoCivil;
import empresaTransporte.utp.entidad.master.EstadoEmpleado;
import empresaTransporte.utp.entidad.master.TipoDoc;
import empresaTransporte.utp.entidad.master.TipoGenero;
import empresaTransporte.utp.entidad.ubigeo.UbigeoDist;
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
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "colaborador", schema = "colaborador")
@Getter
@Setter
public class Colaborador  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_id")
    private Long id;

    @Column(name = "col_codigo")
    private String codigo;

    @Column(name = "col_apepat")
    private String apellidoPaterno;

    @Column(name = "col_apemat")
    private String apellidoMaterno;

    @Column(name = "col_nombre")
    private String nombre;

    @Column(name = "col_numdoi")
    private String numeroIdentificacion;

    @Column(name = "col_fecnac")
    private LocalDate fechaNacimiento;

    @Column(name = "col_telfij")
    private String telefono;

    @Column(name = "col_telcel")
    private String celular;

    @Column(name = "col_numruc")
    private String numeroRuc;

    @Column(name = "col_direcc")
    private String direccion;

    @Column(name = "col_correo")
    private String correo;

    @Column(name = "col_fecing")
    private LocalDate fechaIngreso;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "col_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "col_activo")
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "tdi_id")
    private TipoDoc tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "tge_id")
    private TipoGenero tipoGenero;

    @ManyToOne
    @JoinColumn(name = "esc_id")
    private EstadoCivil estadoCivil;

    @ManyToOne
    @JoinColumn(name = "ese_id")
    private EstadoEmpleado estadoEmpleado;

    @ManyToOne
    @JoinColumn(name = "udi_id")
    private UbigeoDist distrito;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        activo = true;

    }
}
