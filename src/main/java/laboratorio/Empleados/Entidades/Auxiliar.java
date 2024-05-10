package laboratorio.Empleados.Entidades;

import jakarta.persistence.Entity;

@Entity
public class Auxiliar extends Empleado {
    // Constructor
    public Auxiliar() {
    }

    public Auxiliar(String nombre, String apellido, String usuario, String password) {
        super(nombre, apellido, usuario, password);
    }
}
