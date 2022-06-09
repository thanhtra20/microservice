package com.example.animalstore;

import com.example.animalstore.models.Animal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AnimalStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalStoreApplication.class, args);
	}

}
