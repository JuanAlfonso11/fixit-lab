package laboratorio.Resultado.Repositorios;

import laboratorio.Pruebas.Entidades.Prueba;
import laboratorio.Resultado.Entidades.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RepositoryRestController
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
    boolean existsByPrueba(Prueba p);
}
