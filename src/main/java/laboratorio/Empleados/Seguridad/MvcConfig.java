package laboratorio.Empleados.Seguridad;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/indexSecretaria").setViewName("indexSecretaria");
        registry.addViewController("/indexBionalista").setViewName("indexBionalista");
        registry.addViewController("/ars").setViewName("ars");
        registry.addViewController("/doctores").setViewName("doctores");
        registry.addViewController("/empleados").setViewName("empleados");
        registry.addViewController("/pacientes").setViewName("pacientes");
        registry.addViewController("/pruebas").setViewName("pruebas");
        registry.addViewController("/suplidores").setViewName("suplidores");



    }

}
