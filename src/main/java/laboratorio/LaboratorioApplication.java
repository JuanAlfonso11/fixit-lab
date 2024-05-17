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

import laboratorio.Empleados.Entidades.Auxiliar;
import laboratorio.Empleados.Entidades.Bionalista;
import laboratorio.Empleados.Entidades.Empleado;
import laboratorio.Empleados.Entidades.Secretaria;
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
//        Secretaria secretaria = new Secretaria("Ana", "Perez", "anaperez", "password123", "ana@example.com", 5, true);
//        Auxiliar auxiliar = new Auxiliar("Luis", "Gomez", "luisgomez", "password123", "luis@example.com", 3, true);
//        Bionalista bionalista = new Bionalista("Maria", "Lopez", "marialopez", "password123", "maria@example.com", 7, true);
//
//        // Guardando en la base de datos
//        empleadoRepository.save(secretaria);
//        empleadoRepository.save(auxiliar);
//        empleadoRepository.save(bionalista);
//
//        // Mostrar en consola o verificar que se han guardado
//        System.out.println("Empleados agregados: " + empleadoRepository.findAll().size());
    }
}
