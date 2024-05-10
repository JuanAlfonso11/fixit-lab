package laboratorio.Facturacion.Entidades;

import laboratorio.Paciente.Entidades.Paciente;
import jakarta.persistence.*;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_metodo", nullable = false, length = 100)
    private String nombreMetodo;

    @Column(name = "detalle", length = 255)
    private String detalle;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    public MetodoPago() {
    }

    public MetodoPago(String nombreMetodo, String detalle, Paciente paciente) {
        this.nombreMetodo = nombreMetodo;
        this.detalle = detalle;
        this.paciente = paciente;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
