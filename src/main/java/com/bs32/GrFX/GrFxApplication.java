package com.bs32.GrFX;

import com.bs32.GrFX.Repo.ItemRepo;
import com.bs32.GrFX.model.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GrFxApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrFxApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ItemRepo itemRepo){
		return  args ->{
			itemRepo.save(new Item(null, "Grinder", "Santa Cruz", "http://localhost:8080/item/image/item1.png", "blue", 1, 35.50, 50.00));
		};
	}
}
