package laboratorio.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/sign-in")
    public String login() {
        return "sign-in"; // Asegúrate de que tengas un archivo login.html en src/main/resources/templates/
    }
}
