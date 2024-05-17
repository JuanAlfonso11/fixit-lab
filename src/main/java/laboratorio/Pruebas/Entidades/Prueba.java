package laboratorio.Pruebas.Entidades;

import jakarta.persistence.*;
import laboratorio.Paciente.Entidades.Paciente;
import laboratorio.Resultado.Entidades.Resultado;

@Entity
@Table(name = "prueba")
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_prueba", nullable = false, length = 100)
    private String nombrePrueba;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private double precio;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Resultado resultado;

    @Column(name = "activo")
    private boolean activo;

    public Prueba() {
    }

    public Prueba(String nombrePrueba, String descripcion, double precio, Paciente paciente, Resultado resultado) {
        this.nombrePrueba = nombrePrueba;
        this.descripcion = descripcion;
        this.precio = precio;
        this.paciente = paciente;
        this.resultado = resultado;
        this.activo = true; // default value
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
