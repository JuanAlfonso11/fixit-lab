package laboratorio.Pruebas.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import laboratorio.Pruebas.Entidades.Prueba;
import laboratorio.Pruebas.Repositorios.PruebaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pruebas")
public class PruebaRestController {

    @Autowired
    private PruebaRepository pruebaRepository;

    @GetMapping
    public List<Prueba> getAllPruebas() {
        return pruebaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prueba> getPruebaById(@PathVariable Long id) {
        Optional<Prueba> prueba = pruebaRepository.findById(id);
        if (prueba.isPresent()) {
            return ResponseEntity.ok(prueba.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Prueba> addPrueba(@RequestBody Prueba prueba) {
        Prueba savedPrueba = pruebaRepository.save(prueba);
        return ResponseEntity.ok(savedPrueba);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prueba> updatePrueba(@PathVariable Long id, @RequestBody Prueba pruebaDetails) {
        Optional<Prueba> prueba = pruebaRepository.findById(id);
        if (prueba.isPresent()) {
            Prueba updatedPrueba = prueba.get();
            updatedPrueba.setNombrePrueba(pruebaDetails.getNombrePrueba());
            updatedPrueba.setDescripcion(pruebaDetails.getDescripcion());
            updatedPrueba.setPrecio(pruebaDetails.getPrecio());
            updatedPrueba.setPaciente(pruebaDetails.getPaciente());
            updatedPrueba.setResultado(pruebaDetails.getResultado());
            updatedPrueba.setActivo(pruebaDetails.isActivo());
            return ResponseEntity.ok(pruebaRepository.save(updatedPrueba));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrueba(@PathVariable Long id) {
        Optional<Prueba> prueba = pruebaRepository.findById(id);
        if (prueba.isPresent()) {
            pruebaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
