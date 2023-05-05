package Com.EjercicioSpring3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjercicioSpring3Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioSpring3Application.class, args);
		CocheRepository cocheRepository = context.getBean(CocheRepository.class);
		Coche coche = new Coche(null,"toyota","prius", 2010);
		cocheRepository.save(coche);
//		System.out.println(cocheRepository.findAll());
	}

}
