package laboratorio.Email.Servicio;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import laboratorio.Empleados.Entidades.Empleado;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    @Autowired
    private Mailer mailer;

//    // Método para enviar correo de bienvenida a un estudiante
//    public void enviarCorreoBienvenida(Estudiante estudiante) {
//        String asunto = "¡Bienvenido a nuestro Open House 2024!";
//        String cuerpo = cargarContenidoHTML("correo_estudiante.html");
//
//        String nombreCapitalizado = capitalizarPrimeraLetra(estudiante.getNombre());
//        String apellidoCapitalizado = capitalizarPrimeraLetra(estudiante.getApellido());
//
//        cuerpo = cuerpo.replace("{{nombre}}", nombreCapitalizado);
//        cuerpo = cuerpo.replace("{{apellido}}", apellidoCapitalizado);
//        cuerpo = cuerpo.replace("{{carrera}}", estudiante.getCarreraDeInteres());
//
//        Email email = EmailBuilder.startingBlank()
//                .from("cicc-csti@ce.pucmm.edu.do")
//                .to(estudiante.getCorreo())
//                .withSubject(asunto)
//                .withHTMLText(cuerpo)
//                .buildEmail();
//
//        mailer.sendMail(email);
//    }

    // Método para enviar correo de bienvenida a un empleado
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
                .from("ipmx0001@ce.pucmm.edu.do")
                .to(empleado.getCorreo())
                .withSubject(asunto)
                .withHTMLText(cuerpo)
                .buildEmail();

        mailer.sendMail(email);
    }

    // Método para cargar el contenido de un archivo HTML
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
