package laboratorio.Empleados.Entidades;

import jakarta.persistence.Entity;

@Entity
public class Secretaria extends Empleado {
    // Constructor
    public Secretaria() {
    }

    public Secretaria(String nombre, String apellido, String usuario, String password) {
        super(nombre, apellido, usuario, password);
    }
}
