package laboratorio.Paciente.Repositorios;

import laboratorio.Paciente.Entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestController
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT p FROM Paciente p WHERE " +
            "(:nombre IS NULL OR p.nombre LIKE %:nombre%) AND " +
            "(:apellido IS NULL OR p.apellido LIKE %:apellido%) AND " +
            "(:tipoDocumento IS NULL OR p.tipoDocumento = :tipoDocumento) AND " +
            "(:documento IS NULL OR p.documento = :documento) AND " +
            "(:fechaNacimiento IS NULL OR p.fechaNacimiento = :fechaNacimiento) AND " +
            "(:telefono IS NULL OR p.telefono LIKE %:telefono%) AND " +
            "(:direccion IS NULL OR p.direccion LIKE %:direccion%) AND " +
            "(:seguroSalud IS NULL OR p.seguroSalud LIKE %:seguroSalud%)")
    List<Paciente> buscarPorCriterios(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("tipoDocumento") String tipoDocumento,
            @Param("documento") String documento,
            @Param("fechaNacimiento") String fechaNacimiento,
            @Param("telefono") String telefono,
            @Param("direccion") String direccion,
            @Param("seguroSalud") String seguroSalud
    );
}
