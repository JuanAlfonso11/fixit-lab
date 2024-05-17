package laboratorio.Empleados.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bionalistas")
public class Bionalista extends Empleado {
    public Bionalista() {
    }

    public Bionalista(String nombre, String apellido, String usuario, String password, String correo, int tiempoTrabajando, boolean activo) {
        super(nombre, apellido, usuario, password, correo, tiempoTrabajando, activo);
    }
}
