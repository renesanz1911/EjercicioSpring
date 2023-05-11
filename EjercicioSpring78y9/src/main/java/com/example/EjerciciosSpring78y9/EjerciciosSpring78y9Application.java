package com.example.EjerciciosSpring78y9;

import com.example.EjerciciosSpring78y9.entities.LaptopEntity;
import com.example.EjerciciosSpring78y9.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjerciciosSpring78y9Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjerciciosSpring78y9Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);
		LaptopEntity laptop = new LaptopEntity(null,
				"Lenovo",
				"P15, Gen 2",
				"16GB",
				"Intel Core i7, 4 nucleos",
				"1Tb" );
		repository.save(laptop);
	}


}
