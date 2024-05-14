package laboratorio.Pruebas.Repositorios;

import laboratorio.Pruebas.Entidades.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

@RepositoryRestController
public interface PruebaRepository extends JpaRepository<Prueba, Long> {
}
