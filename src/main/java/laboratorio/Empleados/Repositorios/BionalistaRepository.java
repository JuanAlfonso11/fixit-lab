package laboratorio.Empleados.Repositorios;

import laboratorio.Empleados.Entidades.Bionalista;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BionalistaRepository extends JpaRepository<Bionalista, Long> {
}