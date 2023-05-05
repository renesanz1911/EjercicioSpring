package EjercicioSpring2;

import org.springframework.stereotype.Component;

@Component

public class UserService {
    NotificationService notificationService;
    public UserService(NotificationService notificationService) {
        System.out.println("Constructor de UserService");
        this.notificationService = notificationService;
    }
}
