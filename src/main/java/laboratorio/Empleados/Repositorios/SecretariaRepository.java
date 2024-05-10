package laboratorio.Empleados.Repositorios;

import laboratorio.Empleados.Entidades.Secretaria;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {
}