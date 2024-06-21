package laboratorio.Facturacion.Controladores;

import laboratorio.Doctores.Entidades.Doctores;
import laboratorio.Doctores.Repositorios.DoctoresRepository;
import laboratorio.Facturacion.Entidades.Factura;
import laboratorio.Facturacion.Entidades.FacturaRequest;
import laboratorio.Facturacion.Entidades.MetodoPago;
import laboratorio.Facturacion.Repositorios.FacturaRepository;
import laboratorio.Facturacion.Repositorios.MetodoPagoRepository;
import laboratorio.Paciente.Entidades.Paciente;
import laboratorio.Paciente.Repositorios.PacienteRepository;
import laboratorio.Pruebas.Entidades.Prueba;
import laboratorio.Pruebas.Repositorios.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Autowired
    private PruebaRepository pruebaRepository;

    @Autowired
    private DoctoresRepository doctorRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createFactura(@RequestBody FacturaRequest facturaRequest) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(facturaRequest.getPacienteId());
        if (!optionalPaciente.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Paciente no encontrado");
        }

        Paciente paciente = optionalPaciente.get();
        Factura factura = new Factura();
        factura.setPaciente(paciente);
        factura.setFechaEmision(new Date());

        List<Prueba> pruebas = facturaRequest.getPruebas().stream()
                .map(nombrePrueba -> pruebaRepository.findByNombrePrueba(nombrePrueba)
                        .orElseThrow(() -> new RuntimeException("Prueba no encontrada: " + nombrePrueba)))
                .collect(Collectors.toList());

        factura.setPruebas(pruebas);

        double subtotal = pruebas.stream().mapToDouble(Prueba::getCosto).sum();
        double descuento = paciente.getArs().getDescuento();
        double totalDescuento = subtotal * descuento;
        double total = subtotal - totalDescuento;
        factura.setTotal(total);

        MetodoPago metodoPago = metodoPagoRepository.findById(facturaRequest.getMetodoPagoId())
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));
        factura.setMetodoPago(metodoPago);

        if (facturaRequest.getDoctorId() != null) {
            Doctores doctor = doctorRepository.findById(facturaRequest.getDoctorId())
                    .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
            paciente.setDoctores(doctor);
        }
        factura.setNumeroFactura("X-00");
        Factura savedFactura = facturaRepository.save(factura);

        savedFactura.setNumeroFactura("X-00" + savedFactura.getId());
        savedFactura = facturaRepository.save(savedFactura);

        paciente.getFacturas().add(savedFactura);
        paciente.getPruebas().addAll(pruebas);
        pacienteRepository.save(paciente);

        System.out.println("\nFactura procesada: \n" + savedFactura);
        return ResponseEntity.ok(savedFactura);
    }

}