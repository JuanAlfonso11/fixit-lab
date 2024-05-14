package laboratorio.Facturacion.Entidades;

import laboratorio.Paciente.Entidades.Paciente;
import laboratorio.Facturacion.Entidades.MetodoPago;
import jakarta.persistence.*;


import java.util.Date;
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_factura", nullable = false, unique = true)
    private String numeroFactura;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_emision", nullable = false)
    private Date fechaEmision;

    @Column(name = "total", nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id", nullable = false)
    private MetodoPago metodoPago;

    public Factura() {
    }

    public Factura(String numeroFactura, Paciente paciente, Date fechaEmision, double total, MetodoPago metodoPago) {
        this.numeroFactura = numeroFactura;
        this.paciente = paciente;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.metodoPago = metodoPago;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
