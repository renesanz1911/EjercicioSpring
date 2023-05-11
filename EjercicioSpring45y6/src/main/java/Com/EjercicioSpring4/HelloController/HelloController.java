package Com.EjercicioSpring4.HelloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saluda")
    public String saluda(){
        return "Hola mundo";
    }
}
