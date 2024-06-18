package laboratorio;

import laboratorio.Empleados.Entidades.Admin;
import laboratorio.Empleados.Entidades.Empleado;
import laboratorio.Empleados.Repositorios.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class LaboratorioApplication implements CommandLineRunner {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public static void main(String[] args) {
        SpringApplication.run(LaboratorioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        verificarYCrearAdmin();

    }

    private void verificarYCrearAdmin() {
        Optional<Empleado> adminUser = empleadoRepository.findByUsuario("admin");
        if (adminUser.isEmpty()) {
            Admin admin = new Admin("Admin", "Admin", "admin", "admin", "admin@example.com", "0", true, "M");
            empleadoRepository.save(admin);
            System.out.println("Usuario administrador creado: " + admin.getUsuario());
        } else {
            System.out.println("Usuario administrador ya existe: " + adminUser.get().getUsuario());
        }
    }
}
