package laboratorio.ARS.Controladores;

import laboratorio.ARS.Entidades.ARS;
import laboratorio.ARS.Repositorio.ARSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ars")
public class ARSController {

    @Autowired
    private ARSRepository arsRepositorio;

    // Obtener todos los ARS
    @GetMapping
    public List<ARS> getAllARS() {
        return arsRepositorio.findAll();
    }

    // Obtener un ARS por ID
    @GetMapping("/{id}")
    public ResponseEntity<ARS> getARSById(@PathVariable Long id) {
        ARS ars = arsRepositorio.findById(id).orElse(null);
        if (ars == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ars);
    }

    // Crear un nuevo ARS
    @PostMapping
    public ARS createARS(@RequestBody ARS ars) {
        return arsRepositorio.save(ars);
    }

    // Actualizar un ARS existente
    @PutMapping("/{id}")
    public ResponseEntity<ARS> updateARS(@PathVariable Long id, @RequestBody ARS arsDetails) {
        ARS ars = arsRepositorio.findById(id).orElse(null);
        if (ars == null) {
            return ResponseEntity.notFound().build();
        }
        ars.setNombreARS(arsDetails.getNombreARS());
        ars.setRNC(arsDetails.getRNC());
        ars.setRepresentante(arsDetails.getRepresentante());
        ars.setDireccion(arsDetails.getDireccion());
        ars.setTelefono(arsDetails.getTelefono());
        ars.setCorreo(arsDetails.getCorreo());
        ars.setActivo(arsDetails.isActivo());
        ARS updatedARS = arsRepositorio.save(ars);
        return ResponseEntity.ok(updatedARS);
    }

    // Eliminar un ARS
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteARS(@PathVariable Long id) {
        ARS ars = arsRepositorio.findById(id).orElse(null);
        if (ars == null) {
            return ResponseEntity.notFound().build();
        }
        arsRepositorio.delete(ars);
        return ResponseEntity.noContent().build();
    }
}
