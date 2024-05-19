package empresaTransporte.utp.repositorio;

import empresaTransporte.utp.entidad.colaborador.Colaborador;
import empresaTransporte.utp.util.dto.ColaboradorBusquedaResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    @Query("SELECT COUNT(c) FROM Colaborador c")
    long contarColaboradores();

    List<Colaborador> findBancoByActivoTrue();

    List<Colaborador> findByIdIn(List<Long> ids);

    @Query(value = "SELECT clb.col_id as colaboradorId, CONCAT(clb.col_apepat,' ',clb.col_apemat,' ',clb.col_nombre) as persona, " +
            "clb.col_numdoi as numDocumento, glb.grl_descri as grupoLaboral, carg.crg_descri as cargo, eemp.ese_descri as estadoEmpleado " +
            "FROM colaborador.colaborador clb " +
            "LEFT OUTER JOIN master.tipodocide tdoc ON tdoc.tdi_id = clb.tdi_id " +
            "LEFT OUTER JOIN master.estadoempleado eemp ON eemp.ese_id = clb.ese_id " +
            "LEFT OUTER JOIN colaborador.colaborador_laborales clbl ON clbl.col_id = clb.col_id " +
            "LEFT OUTER JOIN master.grupolaboral glb ON glb.grl_id = clbl.grl_id " +
            "LEFT OUTER JOIN master.cargo carg ON carg.crg_id = clbl.crg_id " +
            "WHERE clb.col_activo " +
            "AND (:nombre IS NULL OR lower(clb.col_nombre) ILIKE lower(concat('%', :nombre, '%'))) " +
            "AND (:apellidoPaterno IS NULL OR lower(clb.col_apepat) ILIKE lower(concat('%', :apellidoPaterno, '%'))) " +
            "AND (:apellidoMaterno IS NULL OR lower(clb.col_apemat) ILIKE lower(concat('%', :apellidoMaterno, '%'))) " +
            "AND (:tipoDocumentoId IS NULL OR tdoc.tdi_id = :tipoDocumentoId) " +
            "AND (:numeroDocumento IS NULL OR clb.col_numdoi = :numeroDocumento) " +
            "AND (:estadoEmpleadoId IS NULL OR eemp.ese_id = :estadoEmpleadoId) " +
            "AND (:cargoId IS NULL OR carg.crg_id = :cargoId) " +
            "AND (:grupoLaboralId IS NULL OR glb.grl_id = :grupoLaboralId) " +
            "LIMIT :maximo OFFSET :limite "
    ,nativeQuery = true)
    List<Map<String, Object>> busquedaPaginadaColaborador(
            @Param("nombre") String nombre,
            @Param("apellidoPaterno") String apellidoPaterno,
            @Param("apellidoMaterno") String apellidoMaterno,
            @Param("tipoDocumentoId") Long tipoDocumentoId,
            @Param("numeroDocumento") String numeroDocumento,
            @Param("estadoEmpleadoId") Long estadoEmpleadoId,
            @Param("cargoId") Long cargoId,
            @Param("grupoLaboralId") Long grupoLaboralId,
            @Param("maximo") Integer maximo,
            @Param("limite") Integer limite);

    @Query(value = "SELECT COUNT(clb.*) " +
            "FROM colaborador.colaborador clb " +
            "LEFT OUTER JOIN master.tipodocide tdoc ON tdoc.tdi_id = clb.tdi_id " +
            "LEFT OUTER JOIN master.estadoempleado eemp ON eemp.ese_id = clb.ese_id " +
            "LEFT OUTER JOIN colaborador.colaborador_laborales clbl ON clbl.col_id = clb.col_id " +
            "LEFT OUTER JOIN master.grupolaboral glb ON glb.grl_id = clbl.grl_id " +
            "LEFT OUTER JOIN master.cargo carg ON carg.crg_id = clbl.crg_id " +
            "WHERE clb.col_activo " +
            "AND (:nombre IS NULL OR lower(clb.col_nombre) ILIKE lower(concat('%', :nombre, '%'))) " +
            "AND (:apellidoPaterno IS NULL OR lower(clb.col_apepat) ILIKE lower(concat('%', :apellidoPaterno, '%'))) " +
            "AND (:apellidoMaterno IS NULL OR lower(clb.col_apemat) ILIKE lower(concat('%', :apellidoMaterno, '%'))) " +
            "AND (:tipoDocumentoId IS NULL OR tdoc.tdi_id = :tipoDocumentoId) " +
            "AND (:numeroDocumento IS NULL OR clb.col_numdoi = :numeroDocumento) " +
            "AND (:estadoEmpleadoId IS NULL OR eemp.ese_id = :estadoEmpleadoId) " +
            "AND (:cargoId IS NULL OR carg.crg_id = :cargoId) " +
            "AND (:grupoLaboralId IS NULL OR glb.grl_id = :grupoLaboralId) "
            ,nativeQuery = true)
    Integer busquedaPaginadaColaboradorContar(
            @Param("nombre") String nombre,
            @Param("apellidoPaterno") String apellidoPaterno,
            @Param("apellidoMaterno") String apellidoMaterno,
            @Param("tipoDocumentoId") Long tipoDocumentoId,
            @Param("numeroDocumento") String numeroDocumento,
            @Param("estadoEmpleadoId") Long estadoEmpleadoId,
            @Param("cargoId") Long cargoId,
            @Param("grupoLaboralId") Long grupoLaboralId);





}
