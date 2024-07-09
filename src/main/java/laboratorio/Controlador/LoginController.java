package laboratorio.Controlador;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login"; // Asegúrate de que "login.html" esté en "resources/templates"
    }

    @PostMapping("/login")
    public String performLogin() {
        return "redirect:/index"; // Redirigir a la página principal después del login
    }

//    @GetMapping("/login/error")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login"; // Asegúrate de que "login.html" esté en "resources/templates"
//    }

    @GetMapping("/login/default")
    public String defaultAfterLogin(Authentication authentication) {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ADMIN")) {
            return "redirect:/index";
        } else if (roles.contains("ROLE_SECRETARIA")) {
            return "redirect:/secretaria/indexSecretaria";
        } else if (roles.contains("ROLE_BIONALISTA")) {
            return "redirect:/bionalista/indexBionalista";
        } else {
            return "redirect:/access-denied";
        }
    }
}
