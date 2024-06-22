package laboratorio.Email.Servicio;

import laboratorio.Facturacion.Entidades.Factura;
import laboratorio.Paciente.Entidades.Paciente;
import laboratorio.Pruebas.Entidades.Prueba;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import laboratorio.Empleados.Entidades.Empleado;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private Mailer mailer;

    @Async
    public void enviarCorreoBienvenidaEmpleado(Empleado empleado) {
        String asunto = "¡Bienvenido al equipo!";
        String cuerpo = cargarContenidoHTML("correo_empleado.html");

        String nombreCapitalizado = capitalizarPrimeraLetra(empleado.getNombre());
        String apellidoCapitalizado = capitalizarPrimeraLetra(empleado.getApellido());

        cuerpo = cuerpo.replace("{{nombre}}", nombreCapitalizado);
        cuerpo = cuerpo.replace("{{apellido}}", apellidoCapitalizado);
        cuerpo = cuerpo.replace("{{usuario}}", empleado.getUsuario());
        cuerpo = cuerpo.replace("{{password}}", empleado.getPassword());
        cuerpo = cuerpo.replace("{{tipoempleado}}", empleado.getTipoEmpleado());

        Email email = EmailBuilder.startingBlank()
                .from("noreply@systechs.live")
                .to(empleado.getCorreo())
                .withSubject(asunto)
                .withHTMLText(cuerpo)
                .buildEmail();

        mailer.sendMail(email);
    }

    @Async
    public void enviarCorreoFactura(Paciente paciente, Factura factura, List<Prueba> pruebas) {
        String asunto = "Detalle de su Factura - Laboratorio Médico";
        String cuerpo = cargarContenidoHTML("correo_factura.html");

        cuerpo = cuerpo.replace("{{nombre}}", capitalizarPrimeraLetra(paciente.getNombre()));
        cuerpo = cuerpo.replace("{{apellido}}", capitalizarPrimeraLetra(paciente.getApellido()));
        cuerpo = cuerpo.replace("{{fecha}}", factura.getFechaEmision().toString());
        cuerpo = cuerpo.replace("{{numeroFactura}}", factura.getNumeroFactura());
        cuerpo = cuerpo.replace("{{metodoPago}}", factura.getMetodoPago().getNombreMetodo());
        cuerpo = cuerpo.replace("{{nombreSeguro}}", paciente.getArs().getNombreARS());
        cuerpo = cuerpo.replace("{{descuento}}", String.format("%.2f", paciente.getArs().getDescuento() * 100));

        StringBuilder pruebasHTML = new StringBuilder();
        for (Prueba prueba : pruebas) {
            pruebasHTML.append("<li>").append(prueba.getNombrePrueba()).append(" - $").append(prueba.getCosto()).append("</li>");
        }
        cuerpo = cuerpo.replace("{{pruebas}}", pruebasHTML.toString());
        cuerpo = cuerpo.replace("{{total}}", String.format("%.2f", factura.getTotal()));

        Email email = EmailBuilder.startingBlank()
                .from("noreply@systechs.live")
                .to(paciente.getCorreo())
                .withSubject(asunto)
                .withHTMLText(cuerpo)
                .buildEmail();

        mailer.sendMail(email);
    }


    private String cargarContenidoHTML(String nombreArchivo) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/" + nombreArchivo);
            if (inputStream == null) {
                throw new IOException("Archivo no encontrado: " + nombreArchivo);
            }
            byte[] bytes = inputStream.readAllBytes();
            inputStream.close();
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return ""; // Manejar el error apropiadamente en tu aplicación
        }
    }

    public String capitalizarPrimeraLetra(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return palabra;
        }
        return palabra.substring(0, 1).toUpperCase() + palabra.substring(1);
    }
}
