package Com.EjercicioSpring4;

import Com.EjercicioSpring4.LaptopEntity.LaptopEntity;
import Com.EjercicioSpring4.LaptopRepository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjercicioSpring4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioSpring4Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);
		LaptopEntity laptop = new LaptopEntity(null, "Lenovo", "P15, Gen 2", "16GB", "Intel Core i7, 4 nucleos", "1Tb" );
		repository.save(laptop);
	}
}
