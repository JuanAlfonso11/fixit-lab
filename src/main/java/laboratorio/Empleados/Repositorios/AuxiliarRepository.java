package laboratorio.Empleados.Repositorios;

import laboratorio.Empleados.Entidades.Auxiliar;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AuxiliarRepository extends JpaRepository<Auxiliar, Long> {
}