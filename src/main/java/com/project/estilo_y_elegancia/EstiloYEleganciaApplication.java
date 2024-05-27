package com.project.estilo_y_elegancia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;
import com.project.estilo_y_elegancia.enums.EnCategory;
import com.project.estilo_y_elegancia.enums.EnSize;
import com.project.estilo_y_elegancia.models.MdClothes;
import com.project.estilo_y_elegancia.repositories.ClothesRepository;

@SpringBootApplication
public class EstiloYEleganciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstiloYEleganciaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ClothesRepository clothesRepository) {

		// todo: Agrega mas productos, ahi ahabjao esta la plantilla
		return args -> {
			MdClothes clothesOne = MdClothes.builder().category(EnCategory.ACCESORIOS)
					.description("Reloj de dina")
					.image("url de la imagen")
					.price(32.5)
					.size(EnSize.M)
					.stock(4)
					.build();

			MdClothes clothesTwo = MdClothes.builder().category(EnCategory.ACCESORIOS)
					.description("Reloj de dina")
					.image("url de la imagen")
					.price(400.5)
					.size(EnSize.M)
					.stock(4)
					.build();

			clothesRepository.saveAll(Set.of(clothesOne, clothesTwo));
		};
	}

}
