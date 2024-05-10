package laboratorio.Resultado.Repositorios;

import laboratorio.Resultados.Entidades.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
}
