package laboratorio.Doctores.Controladores;

import laboratorio.Doctores.Entidades.Doctores;
import laboratorio.Doctores.Repositorios.DoctoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
public class DoctoresController {

    @Autowired
    private DoctoresRepository doctoresRepositorio;

    // Obtener todos los doctores
    @GetMapping
    public List<Doctores> getAllDoctores() {
        return doctoresRepositorio.findAll();
    }

    // Obtener un doctor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctores> getDoctorById(@PathVariable Long id) {
        Doctores doctor = doctoresRepositorio.findById(id).orElse(null);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctor);
    }

    // Crear un nuevo doctor
    @PostMapping
    public Doctores createDoctor(@RequestBody Doctores doctor) {
        return doctoresRepositorio.save(doctor);
    }

    // Actualizar un doctor existente
    @PutMapping("/{id}")
    public ResponseEntity<Doctores> updateDoctor(@PathVariable Long id, @RequestBody Doctores doctorDetails) {
        Doctores doctor = doctoresRepositorio.findById(id).orElse(null);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        doctor.setNombre(doctorDetails.getNombre());
        doctor.setApellido(doctorDetails.getApellido());
        doctor.setEspecialidad(doctorDetails.getEspecialidad());
        doctor.setTelefono(doctorDetails.getTelefono());
        doctor.setActivo(doctorDetails.isActivo());
        Doctores updatedDoctor = doctoresRepositorio.save(doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    // Eliminar un doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        Doctores doctor = doctoresRepositorio.findById(id).orElse(null);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        doctoresRepositorio.delete(doctor);
        return ResponseEntity.noContent().build();
    }
}
