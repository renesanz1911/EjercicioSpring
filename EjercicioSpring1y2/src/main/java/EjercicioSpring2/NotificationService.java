package EjercicioSpring2;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    public NotificationService(){
        System.out.println("Constructor de NotificationService");
    }
    public void imprimeSaludo(){
        System.out.println("Hola, desde NotificationService");
    }
}
