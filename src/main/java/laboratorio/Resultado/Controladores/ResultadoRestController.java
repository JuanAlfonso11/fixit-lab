package laboratorio.Resultado.Controladores;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import laboratorio.Resultado.Entidades.*;
import laboratorio.Resultado.Repositorios.ResultadoRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoRestController {
    @Autowired
    private ResultadoRepository resultadoRepository;

    @PostMapping("/add")
    public ResponseEntity<Resultado> addResultado(@RequestBody Resultado resultado) {
        Resultado savedResultado = resultadoRepository.save(resultado);
        return ResponseEntity.ok(savedResultado);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Resultado> getResultadoById(@PathVariable Long id) {
        Optional<Resultado> resultado = resultadoRepository.findById(id);
        if (resultado.isPresent()) {
            return ResponseEntity.ok(resultado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public List<Resultado> getAllResultados() {
        return resultadoRepository.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Resultado> updateResultado(@PathVariable Long id, @RequestBody Resultado resultadoDetails) {
        Optional<Resultado> resultado = resultadoRepository.findById(id);
        if (resultado.isPresent()) {
            Resultado updatedResultado = resultado.get();
            updatedResultado.setResultadoTexto(resultadoDetails.getResultadoTexto());
            updatedResultado.setActivo(resultadoDetails.isActivo());
            return ResponseEntity.ok(resultadoRepository.save(updatedResultado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Resultado> deleteResultado(@PathVariable Long id){
        Resultado existingResultado = resultadoRepository.findById(id).orElse(null);
        if(existingResultado==null){
            return ResponseEntity.notFound().build();
        }
        existingResultado.setActivo(false);
        Resultado updatedResultado = resultadoRepository.save(existingResultado);
        return ResponseEntity.ok(updatedResultado);
    }
}
