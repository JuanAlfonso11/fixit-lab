package laboratorio.Paciente.Controlador;

import laboratorio.Empleados.Entidades.Auxiliar;
import laboratorio.Empleados.Entidades.Bionalista;
import laboratorio.Empleados.Entidades.Empleado;
import laboratorio.Empleados.Entidades.Secretaria;
import laboratorio.Empleados.Repositorios.AuxiliarRepository;
import laboratorio.Empleados.Repositorios.BionalistaRepository;
import laboratorio.Empleados.Repositorios.EmpleadoRepository;
import laboratorio.Empleados.Repositorios.SecretariaRepository;
import laboratorio.Paciente.Entidades.Paciente;
import laboratorio.Paciente.Repositorios.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteRestController {

    @Autowired
    private BionalistaRepository bioanalistaRepository;

    @Autowired
    private AuxiliarRepository auxiliarRepository;

    @Autowired
    private SecretariaRepository secretariaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;


    @GetMapping("/counts")
    public ResponseEntity<Map<String, Long>> getCounts() {
        Map<String, Long> counts = new HashMap<>();
        counts.put("bioanalistas", bioanalistaRepository.count());
        counts.put("auxiliares", auxiliarRepository.count());
        counts.put("secretarias", secretariaRepository.count());
        counts.put("pacientes", pacienteRepository.count());
        return ResponseEntity.ok(counts);
    }

    @PostMapping("/add")
    public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente) {
        Paciente savedPaciente = pacienteRepository.save(new Paciente(
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getTipoDocumento(),
                paciente.getDocumento(),
                paciente.getFechaNacimiento(),
                paciente.getTelefono(),
                paciente.getDireccion(),
                paciente.getSeguroSalud(),
                paciente.isActivo()));

        return ResponseEntity.ok(savedPaciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return ResponseEntity.ok(pacientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente existingPaciente = pacienteRepository.findById(id).orElse(null);
        if (existingPaciente == null) {
            return ResponseEntity.notFound().build();
        }

        existingPaciente.setNombre(paciente.getNombre());
        existingPaciente.setApellido(paciente.getApellido());
        existingPaciente.setTipoDocumento(paciente.getTipoDocumento());
        existingPaciente.setDocumento(paciente.getDocumento());
        existingPaciente.setFechaNacimiento(paciente.getFechaNacimiento());
        existingPaciente.setTelefono(paciente.getTelefono());
        existingPaciente.setDireccion(paciente.getDireccion());
        existingPaciente.setSeguroSalud(paciente.getSeguroSalud());
        existingPaciente.setActivo(paciente.isActivo());

        Paciente updatedPaciente = pacienteRepository.save(existingPaciente);
        return ResponseEntity.ok(updatedPaciente);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Paciente> deletePaciente(@PathVariable Long id) {
        Paciente existingPaciente = pacienteRepository.findById(id).orElse(null);
        if (existingPaciente == null) {
            return ResponseEntity.notFound().build();
        }
        existingPaciente.setActivo(false);
        Paciente updatedPaciente = pacienteRepository.save(existingPaciente);
        pacienteRepository.delete(existingPaciente);
        return ResponseEntity.ok(updatedPaciente);
    }
}
