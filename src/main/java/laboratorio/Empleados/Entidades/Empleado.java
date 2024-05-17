package laboratorio.Empleados.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "usuario", nullable = false, unique = true, length = 50)
    private String usuario;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "tiempo_trabajando", nullable = false)
    private int tiempoTrabajando;  // años trabajando

    @Column(name = "activo", nullable = false)
    private boolean activo;  // para marcar si el empleado está activo

    public Empleado(String nombre, String apellido, String usuario, String password, String correo, int tiempoTrabajando, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.tiempoTrabajando = tiempoTrabajando;
        this.activo = activo;
    }

    public Empleado() {
    }

    // Getters y setters para todos los campos
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTiempoTrabajando() {
        return tiempoTrabajando;
    }

    public void setTiempoTrabajando(int tiempoTrabajando) {
        this.tiempoTrabajando = tiempoTrabajando;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
