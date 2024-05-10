package laboratorio.Pruebas.Repositorios;

import laboratorio.Pruebas.Entidades.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {
}
