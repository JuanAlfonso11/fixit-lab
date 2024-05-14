package laboratorio.Resultado.Repositorios;

import laboratorio.Resultado.Entidades.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

@RepositoryRestController
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
}
