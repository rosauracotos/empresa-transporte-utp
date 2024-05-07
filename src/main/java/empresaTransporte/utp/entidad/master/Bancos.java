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
@Table(name = "bancos", schema = "master")
@Getter
@Setter
public class Bancos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ban_id")
    private Long id;

    @Column(name = "ban_nombre")
    private String nombre;

    @Column(name = "ban_abrevi")
    private String abreviatura;

    @Column(name = "ban_nomcom")
    private String nomcom;

    @Column(name = "ban_numero")
    private String numero;

    @Column(name = "ban_numcta")
    private String numcta;

    @Column(name = "ban_numcci")
    private String numcci;

    @Column(name = "ban_chkenv")
    private Integer chkenv;

    @Column(name = "ban_activo")
    private boolean activo;
}

