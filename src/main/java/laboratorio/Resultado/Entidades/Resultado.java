package laboratorio.Resultado.Entidades;

import laboratorio.Pruebas.Entidades.Prueba;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "resultado")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prueba> pruebas;

    @Column(name = "resultado_texto", length = 255)
    private String resultadoTexto;

    public Resultado() {
    }

    public Resultado(List<Prueba> pruebas, String resultadoTexto) {
        this.pruebas = pruebas;
        this.resultadoTexto = resultadoTexto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Prueba> getPruebas() {
        return pruebas;
    }

    public void setPruebas(List<Prueba> pruebas) {
        this.pruebas = pruebas;
    }

    public String getResultadoTexto() {
        return resultadoTexto;
    }

    public void setResultadoTexto(String resultadoTexto) {
        this.resultadoTexto = resultadoTexto;
    }
}
