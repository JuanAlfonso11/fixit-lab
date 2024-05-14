package laboratorio.Empleados.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "bionalistas")
public class Bionalista extends Empleado {
    // Constructor
    public Bionalista() {
    }

    public Bionalista(String nombre, String apellido, String usuario, String password) {
        super(nombre, apellido, usuario, password);
    }
}
