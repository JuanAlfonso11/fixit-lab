package laboratorio.Paciente.Repositorios;

import laboratorio.Paciente.Entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

@RepositoryRestController
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
