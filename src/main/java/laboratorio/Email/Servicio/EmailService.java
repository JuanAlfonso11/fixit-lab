package laboratorio.Email.Servicio;

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
