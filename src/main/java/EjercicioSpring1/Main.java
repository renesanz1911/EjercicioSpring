package EjercicioSpring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Saluda saluda = (Saluda) context.getBean("saluda");
        System.out.println(saluda.holamundo());
    }
}
