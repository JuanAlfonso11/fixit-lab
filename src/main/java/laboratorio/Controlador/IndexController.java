package Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/ars")
    public String ars(Model model) {
        return "ars";
    }

    @GetMapping("/doctores")
    public String doctores(Model model) {
        return "doctores";
    }

    @GetMapping("/empleados")
    public String empleados(Model model) {
        return "empleados";
    }

    @GetMapping("/pacientes")
    public String pacientes(Model model) {
        return "pacientes";
    }

    @GetMapping("/pruebas")
    public String pruebas(Model model) {
        return "pruebas";
    }

    @GetMapping("/suplidores")
    public String suplidores(Model model) {
        return "suplidores";
    }

    @GetMapping("/indexSecretaria")
    public String indexSecretaria(Model model) {
        return "indexSecretaria";
    }

}