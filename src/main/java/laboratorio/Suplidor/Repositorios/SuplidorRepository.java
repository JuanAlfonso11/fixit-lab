package laboratorio.Suplidor.Repositorios;

import laboratorio.Suplidor.Entidades.Suplidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuplidorRepository extends JpaRepository<Suplidor, Long> {
}
