//package laboratorio;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class LaboratorioApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(LaboratorioApplication.class, args);
//    }
//
//}
package laboratorio;

import laboratorio.Empleados.Entidades.Empleado;
import laboratorio.Empleados.Repositorios.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaboratorioApplication implements CommandLineRunner {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public static void main(String[] args) {
        SpringApplication.run(LaboratorioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear y guardar empleados
//        Empleado emp1 = new Empleado("John", "Doe", "johndoe", "securepassword");
//        Empleado emp2 = new Empleado("Jane", "Doe", "janedoe", "anothersecurepassword");
//
//        // Guardando en la base de datos
//        empleadoRepository.save(emp1);
//        empleadoRepository.save(emp2);
//
//        // Mostrar en consola o verificar que se han guardado
//        System.out.println("Empleados agregados: " + empleadoRepository.findAll().size());
    }
}
