package laboratorio.Empleados.Repositorios;

import laboratorio.Empleados.Entidades.Empleado;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}



